package me.myclude.quartz.timerservice;

import lombok.RequiredArgsConstructor;
import me.myclude.quartz.info.TimerInfo;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

@RequiredArgsConstructor
public class SimpleTriggerListener implements TriggerListener {

    private final SchedulerService schedulerService;

    @Override
    public String getName() {
        return SimpleTriggerListener.class.getSimpleName();
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        final String timerId = trigger.getKey().getName();

        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        TimerInfo info = (TimerInfo) jobDataMap.get(timerId);

        if (!info.isRunForever()) {

            int remainingFireCount = info.getRemainingFireCount();
            if(remainingFireCount == 0) {
                return;
            }
            info.setRemainingFireCount(remainingFireCount - 1);
        }

        schedulerService.updateTimer(timerId, info);
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {

    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {

    }
}
