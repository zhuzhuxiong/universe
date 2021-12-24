package com.universe.schedule.quartz.simple;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

@Slf4j
public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException {
        //通过工厂创建调度器 scheduler
        StdSchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        //构建jobDetail，绑定具体的任务类（helloJob）
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .usingJobData("jobDetail","test jobMap detail")
                .withIdentity("job1", "group1")
                .build();
        //构建触发器 trigger
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .usingJobData("trigger","test jobMap trigger")
                .withIdentity("trigger1", "group1")
                .startNow() //立即执行 or startAt(date)
//                .startAt()
//                .endAt()
//                .withPriority()//优先级
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().
                        withIntervalInSeconds(1) //执行频率（s），eg1次/s
                        .repeatForever())//一直重复执行
                .build();
        //开始执行
        scheduler.scheduleJob(jobDetail,trigger);

        scheduler.start();
        log.info("-------start scheduler---------");

        try {
            //睡眠1分钟，任务在此一分钟内每秒执行一次
            Thread.sleep(1000 * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.shutdown();
        log.info("-------shutdown scheduler---------");

    }
}
