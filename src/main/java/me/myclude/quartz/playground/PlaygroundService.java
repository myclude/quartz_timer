package me.myclude.quartz.playground;

import lombok.RequiredArgsConstructor;
import me.myclude.quartz.info.TimerInfo;
import me.myclude.quartz.jobs.HelloWorldJob;
import me.myclude.quartz.timerservice.SchedulerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaygroundService {

    private final SchedulerService scheduler;

    public void runHelloWorldJob() {

        TimerInfo timerInfo = new TimerInfo();
        timerInfo.setTotalFireCount(5);
        timerInfo.setRemainingFireCount(timerInfo.getTotalFireCount());
        timerInfo.setCron(false);
        timerInfo.setRepeatIntervalMs(5000);
        timerInfo.setInitialOffsetMs(1000);
        timerInfo.setRunForever(false);
        timerInfo.setCallbackData("My Callback data");

        scheduler.schedule(HelloWorldJob.class, timerInfo);
    }

    public List<TimerInfo> getAllRunningTimers() {
        return scheduler.getAllRunningTimer();
    }

    public TimerInfo getRunningTimer(String timerId) {
        return scheduler.getRunningTimer(timerId);
    }

    public Boolean deleteTimer(final String timerId) {
        return scheduler.deleteTimer(timerId);
    }

}
