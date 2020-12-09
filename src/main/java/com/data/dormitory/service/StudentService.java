package com.data.dormitory.service;

import com.data.dormitory.mbg.model.BedSid;
import com.data.dormitory.mbg.model.Stu;

public interface StudentService {

    Stu getStuById(String userId);

    Stu getLogin(String userId, String passwd);

    BedSid getBedId(String sid);

    Stu getStu(Integer bid, Integer did, Integer bbid);

    Stu getStuByPhone(String phone);
}
