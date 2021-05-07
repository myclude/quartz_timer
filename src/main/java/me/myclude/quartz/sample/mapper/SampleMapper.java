package me.myclude.quartz.sample.mapper;

import me.myclude.quartz.jobs.dto.BatchList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleMapper {

    List<BatchList> getAll();

}
