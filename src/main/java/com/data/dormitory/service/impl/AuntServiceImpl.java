package com.data.dormitory.service.impl;

import com.data.dormitory.mbg.mapper.AuntMapper;
import com.data.dormitory.mbg.model.Aunt;
import com.data.dormitory.service.AuntService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("auntService")
public class AuntServiceImpl implements AuntService {

    private static Logger LOGGER = LoggerFactory.getLogger(AuntServiceImpl.class);

    @Autowired
    private AuntMapper auntMapper;

    @Override
    public Aunt getAuntById(String aid) {
        return auntMapper.selectByPrimaryKey(aid);
    }
}
