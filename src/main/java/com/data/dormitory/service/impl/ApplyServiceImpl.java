package com.data.dormitory.service.impl;

import com.data.dormitory.mbg.mapper.AskliveshortMapper;
import com.data.dormitory.mbg.model.Askliveshort;
import com.data.dormitory.service.ApplyService;
import com.data.dormitory.util.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.Calendar;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

    private static Logger LOGGER = LoggerFactory.getLogger(ApplyServiceImpl.class);

    @Autowired
    private AskliveshortMapper askliveshortMapper;

    @Override
    public String[] aplyLeave(Askliveshort askliveshort) throws ParseException {
        // todo 提交筛选策略
        String a = "0";
        String b = null;
        if (appStrategy(askliveshort)) {
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
    public boolean appStrategy(Askliveshort askliveshort) throws ParseException {

        // 先判断日期是否为当天   --》当天则判断时间是否超过10点  --》 未超过  --》允许提交
        //                                                --》  超过   --》 拒绝
        //                     --》 不判断10点
        String dateStart = Tools.getDate(Long.valueOf(askliveshort.getDatestart()));
        String dateToday = Tools.getLocalDate();
        if (dateStart.equals(dateToday)) {
            LOGGER.info("请假日期为当天");
            // 当天10点后不允许请当天假
            return Tools.getCal(dateStart).get(Calendar.HOUR) < 10;
        } else {
            LOGGER.info("申请请假日期不为当天");
            return true;
        }
    }
}
