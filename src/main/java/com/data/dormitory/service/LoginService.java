package com.data.dormitory.service;

import com.data.dormitory.dto.returnmsg.LoginDto;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface LoginService {

    Object login(LoginDto loginDto);

    Map<String, Object> getLoginUser(HttpServletRequest request);

    boolean getInstructorOnLine(HttpServletRequest request, String iid);

}
