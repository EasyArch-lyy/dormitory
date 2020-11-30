package com.data.dormitory.service;

import com.data.dormitory.mbg.model.BedSid;
import com.data.dormitory.mbg.model.Stu;
import com.data.dormitory.mbg.model.TestLogin;

public interface StudentService {

    Stu getUserById(String userId);

    Stu getLogin(String userId, String passwd);

    BedSid getBedId(String sid);

    Stu getStu(Integer bid, Integer did, Integer bbid);
}
