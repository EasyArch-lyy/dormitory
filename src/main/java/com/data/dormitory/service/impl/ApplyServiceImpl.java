package com.data.dormitory.service.impl;

import com.data.dormitory.mbg.mapper.AskliveshortMapper;
import com.data.dormitory.mbg.model.Askliveshort;
import com.data.dormitory.mbg.model.Instructor;
import com.data.dormitory.mbg.model.Stu;
import com.data.dormitory.service.ApplyService;
import com.data.dormitory.service.InstructorService;
import com.data.dormitory.service.LoginService;
import com.data.dormitory.service.StudentService;
import com.data.dormitory.util.RedisUtil;
import com.data.dormitory.util.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Calendar;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

    private static Logger LOGGER = LoggerFactory.getLogger(ApplyServiceImpl.class);

    @Autowired
    private AskliveshortMapper askliveshortMapper;
    @Autowired
    private StudentService studentService;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String[] aplyLeave(Askliveshort askliveshort, HttpServletRequest request) throws ParseException {

        // todo 提交筛选策略
        String a = "0";
        String b = null;
        if (appStrategy(askliveshort)) {

            a = String.valueOf(askliveshortMapper.insert(askliveshort));
            b = "在请假范围内允许提交";
        } else {
            b = "请假当天超过10点不允许提交外出请假";
        }
        // todo 给关联辅导员发消息
        Stu s = studentService.getStuById(askliveshort.getSid());
        Instructor instructor = instructorService.getInstructorByMGid(s.getMid(), s.getGid());
        noticeApprove(instructor, askliveshort, request);
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

    /**
     * 不经过判断进入离线流程(判断时在线发送时转离线操作
     */
    public void neticeOffline(Integer iid, Askliveshort askliveshort) {
        askliveshort.setAssignstate(1);
        redisUtil.lSet(String.valueOf(iid), askliveshort);
        LOGGER.info("已发送离线通知");
    }

    /**
     * 通知对应辅导员审批
     */
    public void noticeApprove(Instructor instructor, Askliveshort askliveshort, HttpServletRequest request) {

        if (loginService.getInstructorOnLine(request, instructor.getIid())) {
            // 不在线为true
            LOGGER.info("该辅导员离线，进入离线流程");
            // 将审批信息存入redis，以<key:iid,value Askliveshort>形式存储
            askliveshort.setAssignstate(1);
            redisUtil.lSet(instructor.getIid(), askliveshort);
        } else {
            // 在线则进入webSocket流程
            LOGGER.info("该辅导员在线已发起通知");
        }
    }
}
