package com.mrjason.quartz;


import com.mrjason.service.UsersService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class QuartzDemo implements Job {

    @Autowired
    private UsersService usersService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Execute.."+new Date());
        this.usersService.addUsers();
    }
}
