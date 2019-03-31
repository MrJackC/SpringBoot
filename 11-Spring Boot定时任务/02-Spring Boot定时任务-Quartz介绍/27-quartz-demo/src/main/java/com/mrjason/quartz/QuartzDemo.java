package com.mrjason.quartz;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/*
定义任务类
 */
public class QuartzDemo  implements Job {

    /*
    任务被触发时所执行的方法
     */
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Execute。。。。。"+new Date());
    }
}
