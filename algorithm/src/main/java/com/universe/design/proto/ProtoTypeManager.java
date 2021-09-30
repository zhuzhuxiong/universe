package com.universe.design.proto;

import java.util.HashMap;

public class ProtoTypeManager {

   HashMap map =  new HashMap<String,Shape>();

   public ProtoTypeManager(){
       map.put("circle",new Circle());
   }

   public void addProto(String key,Shape value){
       map.put(key, value);
   }

    public void removeProto(String key){
        map.remove(key);
    }

    public Shape getProto(String key) throws CloneNotSupportedException {

        Shape shape = (Shape) map.get(key);
        return shape.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ProtoTypeManager protoTypeManager = new ProtoTypeManager();
        Circle circle = (Circle)protoTypeManager.getProto("circle");
        circle.square(1);
    }

}
