package com.data.dormitory.service.impl;

import com.data.dormitory.mbg.mapper.InstructorMapper;
import com.data.dormitory.mbg.model.Instructor;
import com.data.dormitory.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 辅导员service类
 */
@Service("instructorService")
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorMapper instructorMapper;

    @Override
    public Instructor getInstructorById(String iid) {
        return instructorMapper.selectByPrimaryKey(iid);
    }

    @Override
    public Instructor getInstructorByMGid(Integer mid, Integer gid) {

        return instructorMapper.selectByMidGid(mid, gid);
    }
}
