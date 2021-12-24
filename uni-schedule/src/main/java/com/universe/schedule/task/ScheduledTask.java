package com.universe.schedule.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author
 */
@Slf4j
@Component
public class ScheduledTask {

//    @Scheduled(fixedRate = 5000)
    public void echoTimeStamp(){
        System.out.println("now:{}" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }

}
