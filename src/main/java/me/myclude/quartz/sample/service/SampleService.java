package me.myclude.quartz.sample.service;

import lombok.RequiredArgsConstructor;
import me.myclude.quartz.sample.dto.Account;
import me.myclude.quartz.sample.mapper.SampleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SampleService {

    private final SampleMapper mapper;

    public List<Account> getAll() {
        return mapper.getAll();
    }
}
