package com.project.service;

import com.project.dao.CounterDao;
import com.project.model.CounterRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
public class MainService {
    private final CounterDao counterDao;

    public MainService(CounterDao counterDao) {
        this.counterDao = counterDao;
    }


    @Transactional
    public int update(CounterRequest counterRequest) {
        return counterDao.update(counterRequest.getId(), counterRequest.getAdd());
    }
}
