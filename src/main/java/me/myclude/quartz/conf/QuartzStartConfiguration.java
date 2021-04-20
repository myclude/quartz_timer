package me.myclude.quartz.conf;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.myclude.quartz.jobs.HelloWorldJob;
import me.myclude.quartz.jobs.dto.BatchList;
import me.myclude.quartz.sample.dto.Account;
import me.myclude.quartz.sample.service.SampleService;
import me.myclude.quartz.timerservice.SchedulerService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class QuartzStartConfiguration {

    private final SchedulerService service;
    private final SampleService sampleService;

    @PostConstruct
    public void start() {

        //최초 수행 시 해당 메소드에서 진행
        log.info("JobController start invoked!!!!");

        List<BatchList> allData = sampleService.getAll();

        for(BatchList a : allData) {
            System.out.println("a.toString() = " + a.toString());
        }

    }

}
