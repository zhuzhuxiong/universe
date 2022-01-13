package com.universe.vertx.demo.web.chat;

import com.universe.vertx.util.Runner;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.SockJSBridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * @author L
 */
public class ChatServer extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runExample(ChatServer.class);
    }

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);

        // Allow events for the designated addresses in/out of the event bus bridge
        SockJSBridgeOptions opts = new SockJSBridgeOptions()
                .addInboundPermitted(new PermittedOptions().setAddress("chat.to.server"))
                .addOutboundPermitted(new PermittedOptions().setAddress("chat.to.client"));

        // Create the event bus bridge and add it to the router.
        SockJSHandler ebHandler = SockJSHandler.create(vertx);
        router.mountSubRouter("/eventbus", ebHandler.bridge(opts));

        // Create a router endpoint for the static content.
        router.route().handler(StaticHandler.create());

        // Start the web server and tell it to use the router to handle requests.
        vertx.createHttpServer().requestHandler(router).listen(8080);

        EventBus eb = vertx.eventBus();

        // Register to listen for messages coming IN to the server
        eb.consumer("chat.to.server").handler(message -> {
            // Create a timestamp string
            String timestamp = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).format(Date.from(Instant.now()));
            // Send the message back out to all clients with the timestamp prepended.
            eb.publish("chat.to.client", timestamp + ": " + message.body());
        });

    }
}
