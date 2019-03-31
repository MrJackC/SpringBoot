package com.mrjason.scheduled;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**

 * @Description:    Scheduled定时任务

 * @Author:         MrJason

 * @CreateDate:     2019/3/31 6:10 PM

 * @UpdateUser:     Mrjason

 * @UpdateDate:     2019/3/31 6:10 PM

 * @UpdateRemark:   修改内容

 * @Version:        1.0

 */

@Component
public class ScheduledDemo {
    /**
     * 定时任务方法
     * @Scheduled:设置定时任务
     * cron属性：cron表达式。定时任务触发是时间的一个字符串表达形式
     */
    @Scheduled(cron="0/2 * * * * ?")
    public void scheduledMethod(){
        System.out.println("定时器被触发"+new Date());
    }

    
}
