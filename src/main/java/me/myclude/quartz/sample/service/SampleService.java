package me.myclude.quartz.sample.service;

import lombok.RequiredArgsConstructor;
import me.myclude.quartz.jobs.dto.BatchList;
import me.myclude.quartz.sample.mapper.SampleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SampleService {

    private final SampleMapper mapper;

    public List<BatchList> getAll() {
        return mapper.getAll();
    }
}
