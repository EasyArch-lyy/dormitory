package com.data.dormitory.service.impl;

import com.data.dormitory.dto.returnmsg.LoginDto;
import com.data.dormitory.dto.returnmsg.MsgReturn;
import com.data.dormitory.mbg.model.Aunt;
import com.data.dormitory.mbg.model.Stu;
import com.data.dormitory.service.AuntService;
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
    @Autowired
    private AuntService auntService;

    @Override
    public Object login(LoginDto loginDto) {
        MsgReturn msgReturn = null;
        switch (loginDto.getRank()) {
            case 1:
                Stu stu = null;
                stu = studentService.getStuById(loginDto.getUserName());
                if (stu != null) {
                    if (stu.getSpasswd().equals(loginDto.getPassword())) {
                        msgReturn = new MsgReturn(loginDto.getRank(), stu);
                        return msgReturn;
                    }
                }
            case 2:
                Aunt aunt = null;
                aunt = auntService.getAuntById(loginDto.getUserName());
                if(aunt != null){
                    if (aunt.getApasswd().equals(loginDto.getPassword())) {
                        msgReturn = new MsgReturn(loginDto.getRank(), aunt);
                        return msgReturn;
                    }
                }
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
