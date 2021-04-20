package me.myclude.quartz.sample.mapper;

import me.myclude.quartz.jobs.dto.BatchList;
import me.myclude.quartz.sample.dto.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleMapper {

    List<BatchList> getAll();

}
