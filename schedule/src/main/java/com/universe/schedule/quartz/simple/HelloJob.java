package com.universe.schedule.quartz.simple;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * jobDetail
 * print time
 */
@Slf4j
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("hello world jobDetail:{}",jobExecutionContext.getJobDetail().getJobDataMap().get("jobDetail"));
        log.info("hello world trigger:{}",jobExecutionContext.getTrigger().getJobDataMap().get("trigger"));
        log.info("hello world job:{}",new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }
}
