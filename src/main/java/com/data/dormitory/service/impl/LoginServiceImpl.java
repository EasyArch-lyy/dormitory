package com.data.dormitory.service.impl;

import com.data.dormitory.dto.LoginDto;
import com.data.dormitory.dto.MsgReturn;
import com.data.dormitory.mbg.model.Stu;
import com.data.dormitory.service.LoginService;
import com.data.dormitory.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    private static Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private StudentService studentService;

    @Override
    public Object login(LoginDto loginDto) {
        switch (loginDto.getRank()) {
            case 1:
                Stu stu = null;
                stu = studentService.getUserById(loginDto.getUserName());
                if (stu != null) {
                    if (stu.getSpasswd().equals(loginDto.getPassword())) {
                        return stu;
                    }
                }
                MsgReturn msgReturn =new MsgReturn();
                msgReturn.setStu(stu);
                msgReturn.setCollege();
                msgReturn.setSubject();
                msgReturn.setRating();
                msgReturn.setGender();
                return msgReturn;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
        return null;
    }
}
