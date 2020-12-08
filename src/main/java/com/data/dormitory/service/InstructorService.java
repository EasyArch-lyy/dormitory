package com.data.dormitory.service;

import com.data.dormitory.mbg.model.Instructor;

public interface InstructorService {

    Instructor getInstructorById(String iid);

    Instructor getInstructorByMGid(Integer mid, Integer gid);
}
