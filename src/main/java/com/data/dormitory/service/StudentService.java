package com.data.dormitory.service;

import com.data.dormitory.mbg.model.TestLogin;

public interface StudentService {

    TestLogin getUserById(Integer userId);

    boolean getLogin(Integer userId, String passwd);

}
