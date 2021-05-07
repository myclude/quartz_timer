package me.myclude.quartz.conf;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.myclude.quartz.info.TimerInfo;
import me.myclude.quartz.jobs.dto.BatchList;
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

        List<BatchList> allData;

        try {
            allData = sampleService.getAll();
        } catch (Exception e) {
            log.error("Data Select Exception!!", e);
            throw e;
        }

        if (allData != null) {

            for (BatchList a : allData) {

                System.out.println("a.toString() = " + a.toString());

                try {

                    Class<?> batchClass = Class.forName(a.getBatchName());

                    log.debug("⚉⚉⚉⚉⚉⚉⚉ batch class name : {} ⚉⚉⚉⚉⚉⚉⚉⚉", batchClass.getSimpleName());

                    TimerInfo timerInfo = TimerInfo.builder()
                            .totalFireCount(a.getTotalFireCount())
                            .remainingFireCount(a.getRemainingFireCount())
                            .isCron(a.isCron())
                            .repeatIntervalMs(a.getRepeatIntervalMs())
                            .initialOffsetMs(a.getInitialOffsetMs())
                            .runForever(a.isRunForever())
                            .callbackData(a.getCallBackData())
                            .cronExpr(a.getCronExpr())
                            .build();

                    service.schedule(batchClass, timerInfo);

                } catch (ClassNotFoundException e) {
                    log.error("this class is not found !! {}", a.getBatchName());
                } catch (Exception e) {
                    log.error("holly Shit!!" + a.getBatchName());
                    log.error(e.getMessage());
                }
            }
        } else {
            log.info("no scheduler!! we just waited...");
        }

    }

}
