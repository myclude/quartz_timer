package me.myclude.quartz.playground;

import lombok.RequiredArgsConstructor;
import me.myclude.quartz.info.TimerInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timer")
@RequiredArgsConstructor
public class PlaygroundController {

    private final PlaygroundService service;

    @PostMapping("/runhelloworld")
    public void runHelloWorldJob() {
        service.runHelloWorldJob();
    }

    @GetMapping
    public List<TimerInfo> getAllRunningTimers() {
        return service.getAllRunningTimers();
    }

    @GetMapping("/{timerId}")
    public TimerInfo getRunningTimer(@PathVariable String timerId) {
        return service.getRunningTimer(timerId);
    }

    @DeleteMapping("/{timerId}")
    public boolean deleteTimer(@PathVariable String timerId) {
        return service.deleteTimer(timerId);
    }
}
