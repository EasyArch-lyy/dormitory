package com.data.dormitory.service.impl;

import com.data.dormitory.mbg.mapper.RearteachMapper;
import com.data.dormitory.mbg.model.Rearteach;
import com.data.dormitory.service.RearteachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rearteachService")
public class RearteachServiceImpl implements RearteachService {

    @Autowired
    private RearteachMapper rearteachMapper;

    @Override
    public Rearteach getRearById(String tid) {
        return rearteachMapper.selectByPrimaryKey(tid);
    }
}
