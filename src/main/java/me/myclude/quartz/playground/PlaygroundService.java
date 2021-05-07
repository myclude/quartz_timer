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

        TimerInfo timerInfo = TimerInfo.builder()
                .totalFireCount(5)
                .remainingFireCount(5)
                .isCron(false)
                .repeatIntervalMs(5000)
                .initialOffsetMs(1000)
                .runForever(false)
                .callbackData("My Callback data")
                .build();

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
