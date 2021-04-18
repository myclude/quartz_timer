package me.myclude.quartz.jobs;

import lombok.extern.slf4j.Slf4j;
import me.myclude.quartz.info.TimerInfo;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloWorldJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        TimerInfo info = (TimerInfo) jobDataMap.get(HelloWorldJob.class.getSimpleName());
        log.info("Remaining fire count is '{}'", info.getRemainingFireCount());

    }
}
