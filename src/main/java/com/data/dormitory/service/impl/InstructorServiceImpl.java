package com.data.dormitory.service.impl;

import com.data.dormitory.mbg.mapper.AskliveshortMapper;
import com.data.dormitory.mbg.mapper.InstructorMapper;
import com.data.dormitory.mbg.model.Instructor;
import com.data.dormitory.service.InstructorService;
import com.data.dormitory.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 辅导员service类
 */
@Service("instructorService")
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private InstructorMapper instructorMapper;
    @Autowired
    private AskliveshortMapper askliveshortMapper;

    @Override
    public Instructor getInstructorById(String iid) {
        return instructorMapper.selectByPrimaryKey(iid);
    }

    @Override
    public Instructor getInstructByPhone(String phone) {
        return instructorMapper.selectInstructByPhone(phone);
    }

    @Override
    public Instructor getInstructorByMGid(Integer mid, Integer gid) {

        return instructorMapper.selectByMidGid(mid, gid);
    }

    @Override
    public List<Object> getApply(String iid) {
        List<Object> list = new ArrayList<>();
        long endIndex = redisUtil.lGetListSize(iid);
        if (endIndex > 0) {
            list = redisUtil.lGet(iid, 0, endIndex);
        }
        return list;
    }

    @Override
    public boolean operateApply(Integer id, boolean operate) {

        if (operate) {
            askliveshortMapper.updateAsklive(id, "审批通过");
            return true;
        } else {
            askliveshortMapper.updateAsklive(id, "审批拒绝");
            return false;
        }
    }

    /**
     * 将登录上的辅导员加入webSocket
     */
    public void test(){

    }
}
