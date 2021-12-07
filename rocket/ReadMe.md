# RocketMq 实践demo

## 基础Demo
### 消息方式方式
#### Producer-同步消息-SyncProducer
#### Producer-异步消息-AsyncProducer
#### Producer-单项消息-OnewayProducer

### 消息消费-SimpleConsumer

## 顺序消息
### 顺序生产消息 -- com.universe.rocket.order.Producer
### 顺序消费消息 -- com.universe.rocket.order.Consumer

## 延时消息
### 延时生产者：com.universe.rocket.schedule.ScheduleProducer -- setDelayTimeLevel();
### 延时消费者：com.universe.rocket.schedule.ScheduleConsumer

## 批量消息
### 生产者 -- com.universe.rocket.batch.Producer
### 消息分割 -- com.universe.rocket.batch.ListSplitter

## 过滤消息

## 消息事务
### 生产者--com.universe.rocket.transaction.Producer
### 事务监听--com.universe.rocket.transaction.TransactionListenerImpl


## logappender

 
