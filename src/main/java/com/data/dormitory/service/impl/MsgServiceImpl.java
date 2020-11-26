package com.data.dormitory.service.impl;

import com.data.dormitory.mbg.mapper.HygieneNumMapper;
import com.data.dormitory.mbg.mapper.PunishMapper;
import com.data.dormitory.mbg.model.HygieneNum;
import com.data.dormitory.mbg.model.Punish;
import com.data.dormitory.service.MsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("msgServiceImpl")
public class MsgServiceImpl implements MsgService {

    private static Logger LOGGER = LoggerFactory.getLogger(MsgServiceImpl.class);

    @Autowired
    private HygieneNumMapper hygieneNumMapper;
    @Autowired
    private PunishMapper punishMapper;

    public Integer addPunish(Punish punish) {

        return punishMapper.insertSelective(punish);
    }

    public Integer addHygiene(HygieneNum hygieneNum) {

        return hygieneNumMapper.insertSelective(hygieneNum);
    }
}
