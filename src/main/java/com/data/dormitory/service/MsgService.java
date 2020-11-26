package com.data.dormitory.service;

import com.data.dormitory.mbg.model.HygieneNum;
import com.data.dormitory.mbg.model.Punish;

public interface MsgService {

    Integer addPunish(Punish punish);

    Integer addHygiene(HygieneNum hygieneNum);
}
