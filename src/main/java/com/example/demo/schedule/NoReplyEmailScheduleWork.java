package com.example.demo.schedule;

import com.example.demo.service.CronService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class NoReplyEmailScheduleWork implements SchedulingConfigurer {

    @Autowired
    private CronService cronService;


    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(
                () -> {
                    Thread thread = Thread.currentThread();
//                    System.out.println(thread.getName() + new Date());
                },
                triggerContext -> {
                    String cron = cronService.getCronExpression(2L).getCron();
                    if (StringUtils.isEmpty(cron)) {
                        // Omitted Code ..
                    }
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
