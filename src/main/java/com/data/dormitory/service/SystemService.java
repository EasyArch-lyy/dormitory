package com.data.dormitory.service;

import com.data.dormitory.mbg.model.Instructor;
import com.data.dormitory.mbg.model.Rearteach;

public interface SystemService {

    Integer createRearAccount(Rearteach rearteach);

    Integer delRearAccount(String tid);

    Integer createInstructorAccount(Instructor instructor);

    Integer delInstructorById(String iid);

}
