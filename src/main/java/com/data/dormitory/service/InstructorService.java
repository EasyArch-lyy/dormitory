package com.data.dormitory.service;

import com.data.dormitory.mbg.model.Askliveshort;
import com.data.dormitory.mbg.model.Instructor;

import java.util.List;

public interface InstructorService {

    Instructor getInstructorById(String iid);

    Instructor getInstructByPhone(String phone);

    Instructor getInstructorByMGid(Integer mid, Integer gid);

    List<Object> getApply(String iid);

    boolean operateApply(Integer id, boolean operate);
}
