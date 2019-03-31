package com.mrjason;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**

 * @Description:    Scheduled定时任务

 * @Author:         MrJason

 * @CreateDate:     2019/3/31 6:10 PM

 * @UpdateUser:     Mrjason

 * @UpdateDate:     2019/3/31 6:10 PM

 * @UpdateRemark:   修改内容

 * @Version:        1.0

 */

@SpringBootApplication
@EnableScheduling  //对 Scheduled  进行开始使用
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
