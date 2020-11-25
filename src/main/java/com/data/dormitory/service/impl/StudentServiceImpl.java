package com.data.dormitory.service.impl;

import com.data.dormitory.mbg.mapper.TestLoginMapper;
import com.data.dormitory.mbg.model.TestLogin;
import com.data.dormitory.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private TestLoginMapper testLoginMapper;

    private static Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    public TestLogin getUserById(Integer userId) {

        return testLoginMapper.selectByPrimaryKey(userId);
    }

    public boolean getLogin(Integer userId, String passwd) {

        TestLogin testLogin = testLoginMapper.selectByPrimaryKey(userId);
        return testLogin.getPasswd().equals(passwd);
    }

}
