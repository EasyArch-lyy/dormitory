package com.data.dormitory.service.impl;

import com.data.dormitory.mbg.mapper.BedSidMapper;
import com.data.dormitory.mbg.mapper.StuMapper;
import com.data.dormitory.mbg.mapper.TestLoginMapper;
import com.data.dormitory.mbg.model.BedSid;
import com.data.dormitory.mbg.model.Stu;
import com.data.dormitory.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    private static Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private BedSidMapper bedSidMapper;
    @Autowired
    private StuMapper stuMapper;

    public Stu getStuById(String userId) {
        return stuMapper.selectByPrimaryKey(userId);
    }

    public Stu getLogin(String userId, String passwd) {

        Stu stuLogin = stuMapper.selectByPrimaryKey(userId);
        if (stuLogin == null) {
            return stuLogin;
        } else {
            if (stuLogin.getSpasswd().equals(passwd)) {
                return stuLogin;
            }
        }
        return new Stu();
    }

    @Override
    public BedSid getBedId(String sid) {
        return bedSidMapper.selectByPrimaryKey(sid);
    }

    @Override
    public Stu getStu(Integer bid, Integer did, Integer bbid) {
        return stuMapper.getStuByNum(bid, did, bbid);
    }

    @Override
    public Stu getStuByPhone(String phone) {
        return stuMapper.getStuByPhone(phone);
    }

}
