package com.data.dormitory.service.impl;

import com.data.dormitory.mbg.mapper.InstructorMapper;
import com.data.dormitory.mbg.mapper.RearteachMapper;
import com.data.dormitory.mbg.model.Instructor;
import com.data.dormitory.mbg.model.Rearteach;
import com.data.dormitory.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("systemService")
public class SystemServiceImpl implements SystemService {

    private static Logger LOGGER = LoggerFactory.getLogger(SystemServiceImpl.class);

    @Autowired
    private RearteachMapper rearteachMapper;

    @Autowired
    private InstructorMapper instructorMapper;

    @Override
    public Integer createRearAccount(Rearteach rearteach) {
        return rearteachMapper.insert(rearteach);
    }

    @Override
    public Integer delRearAccount(String tid) {
        return rearteachMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public Integer createInstructorAccount(Instructor instructor) {
        return instructorMapper.insert(instructor);
    }

    @Override
    public Integer delInstructorById(String iid) {
        return instructorMapper.deleteByPrimaryKey(iid);
    }
}
