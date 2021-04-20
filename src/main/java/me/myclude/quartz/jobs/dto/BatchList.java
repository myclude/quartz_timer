package me.myclude.quartz.jobs.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BatchList {

    private long id;
    private String batchName;
    private int totalFireCount;
    private int remainingFireCount;
    private boolean runForever;
    private boolean isCron;
    private long repeatIntervalMs;
    private long initialOffsetMs;
    private String cronExpr;
    private String callBackData;

}
