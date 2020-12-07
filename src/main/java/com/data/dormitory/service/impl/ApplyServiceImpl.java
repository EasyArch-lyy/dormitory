package com.data.dormitory.service.impl;

import com.data.dormitory.mbg.mapper.AskliveshortMapper;
import com.data.dormitory.mbg.model.Askliveshort;
import com.data.dormitory.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private AskliveshortMapper askliveshortMapper;
//
    @Override
    public String[] aplyLeave(Askliveshort askliveshort) {
        // todo 提交筛选策略
        String a = "0";
        String b = null;
        if (appStrategy(askliveshort.getDatestart(), askliveshort.getDateend())) {

            a = String.valueOf(askliveshortMapper.insert(askliveshort));
            b = "在请假范围内允许提交";
        } else {
            b= "请假当天超过10点不允许提交外出请假";
        }
        // todo 提交后给关联辅导员发消息
        return new String[]{a, b};
    }

    /**
     * 提交前筛选策略(获取当前小时>22不允许提交
     */
    public boolean appStrategy(String dataStart, String dataEnd) {

        if (Integer.valueOf(dataStart).equals(System.currentTimeMillis())) {
            // 当天

        }
        // 先判断日期是否为当天   --》当天则判断时间是否超过10点  --》 未超过  --》允许提交
        //                                                --》  超过  --》 拒绝
        //                     --》 不判断10点


        return false;
    }
}
