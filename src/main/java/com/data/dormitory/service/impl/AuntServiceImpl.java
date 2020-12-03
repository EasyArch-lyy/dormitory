package com.data.dormitory.service.impl;

import com.data.dormitory.mbg.model.Aunt;
import com.data.dormitory.service.AuntService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("auntService")
public class AuntServiceImpl implements AuntService {

    private static Logger LOGGER = LoggerFactory.getLogger(AuntServiceImpl.class);

    @Override
    public Aunt getAuntById(String userId) {
        return null;
    }
}
