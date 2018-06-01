package com.yuwan.manager.service.impl;

import com.yuwan.manager.dao.TestMapper;
import com.yuwan.manager.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public String queryDate(){
        return this.testMapper.queryDate();
    }
}
