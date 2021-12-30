package com.universe.uninetty.demo.fundamental.time.pojo;

import java.util.Date;

/**
 *
 */
public class TimePojo {

    private long value;

    public TimePojo(){
        this(System.currentTimeMillis() / 1000L + 2208988800L);
    }

    public TimePojo(long value){
        this.value = value;
    }

    public long getValue(){
        return value;
    }

    @Override
    public String toString() {
        return "TimePojo{" + "value=" + new Date((getValue() - 2208988800L) * 1000L) + '}';
    }
}
