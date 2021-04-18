package me.myclude.quartz.info;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class TimerInfo implements Serializable {

    //총 실행 횟수
    private int totalFireCount;
    //남은 실행 횟수
    private int remainingFireCount;
    //영구 실행여부
    private boolean runForever;
    //CronTrigger 여부
    private boolean isCron;
    //반복 실행 간격
    private long repeatIntervalMs;
    //초기 오프셋 (즉시실행 시 0)
    private long initialOffsetMs;
    //Cron Expr
    private String cronExpr;
    //만들어 진 job의 데이터를 전달해야 할 경우 (전달정보)
    private String callbackData;

}
