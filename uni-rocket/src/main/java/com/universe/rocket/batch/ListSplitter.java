package com.universe.rocket.batch;

import org.apache.rocketmq.common.message.Message;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * todo 批量发送 分批次方法
 */
public class ListSplitter implements Iterator<List<Message>>{

    //批量消息最大不能超过4m
    private final int SIZE_LIMIT = 1024 * 1024 * 4;
    private final List<Message> messages;
    private int currIndex;

    public ListSplitter(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean hasNext() {
        return currIndex < messages.size();
    }

    @Override
    public List<Message> next() {
        int startIndex = getStartIndex();
        int nextIndex = startIndex;
        int totalSize = 0;
        for (;nextIndex < messages.size();nextIndex++){
            Message message = messages.get(nextIndex);
            int size = calcMessageSize(message);
            if (size + totalSize > SIZE_LIMIT){
                break;
            }else {
                totalSize = totalSize + size;
            }
        }
        List<Message> messages = this.messages.subList(startIndex, nextIndex);
        currIndex = nextIndex;
        return messages;
    }

    private int getStartIndex(){
        Message curMessage = messages.get(currIndex);
        int size = calcMessageSize(curMessage);
        while (size > SIZE_LIMIT){
            currIndex += 1;
            Message message = messages.get(currIndex);
            size = calcMessageSize(message);
        }
        return currIndex;
    }

    private int calcMessageSize(Message message){
        int length = message.getBody().length + message.getTopic().length();
        Map<String, String> properties = message.getProperties();
        for (Map.Entry<String,String> entry :properties.entrySet()) {
            length += entry.getKey().length() + entry.getValue().length();
        }
        length = length + 20;//日志开销 TODO 预估？
        return length;
    }
}
