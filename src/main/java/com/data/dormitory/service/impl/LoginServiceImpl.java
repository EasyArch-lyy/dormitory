package com.data.dormitory.service.impl;

import com.data.dormitory.dto.returnmsg.LoginDto;
import com.data.dormitory.dto.returnmsg.MsgReturn;
import com.data.dormitory.mbg.model.Aunt;
import com.data.dormitory.mbg.model.Instructor;
import com.data.dormitory.mbg.model.Rearteach;
import com.data.dormitory.mbg.model.Stu;
import com.data.dormitory.service.AuntService;
import com.data.dormitory.service.InstructorService;
import com.data.dormitory.service.LoginService;
import com.data.dormitory.service.RearteachService;
import com.data.dormitory.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    private static Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private StudentService studentService;
    @Autowired
    private AuntService auntService;
    @Autowired
    private RearteachService rearteachService;
    @Autowired
    private InstructorService instructorService;

    @Override
    public Object login(LoginDto loginDto) {
        MsgReturn msgReturn = null;
        switch (loginDto.getRank()) {
            // 学生登录
            case 1:
                Stu stu = null;
                stu = studentService.getStuById(loginDto.getUserName());
                if (stu != null) {
                    if (stu.getSpasswd().equals(loginDto.getPassword())) {
                        msgReturn = new MsgReturn(loginDto.getRank(), stu);
                    }
                }
                break;
            case 2:
                // 宿管登录
                Aunt aunt = null;
                aunt = auntService.getAuntById(loginDto.getUserName());
                if(aunt != null){
                    if (aunt.getApasswd().equals(loginDto.getPassword())) {
                        msgReturn = new MsgReturn(loginDto.getRank(), aunt);
                    }
                }
                break;
            case 3:
                // 后勤登录
                Rearteach rearteach = null;
                rearteach = rearteachService.getRearById(loginDto.getUserName());
                if (rearteach != null) {
                    if (rearteach.getTpasswd().equals(loginDto.getPassword())) {
                        msgReturn = new MsgReturn(loginDto.getRank(), rearteach);
                    }
                }
                break;
            case 4:
                // 辅导员登录
                Instructor instructor = null;
                instructor = instructorService.getInstructorById(loginDto.getUserName());
                if (instructor != null) {
                    if (instructor.getIpasswd().equals(loginDto.getPassword())) {
                        msgReturn = new MsgReturn(loginDto.getRank(), instructor);
                    }
                }
                break;
            case 5:
                Rearteach sys = null;
                sys = rearteachService.getRearById(loginDto.getUserName());
                if (sys != null) {
                    if (sys.getTpasswd().equals(loginDto.getPassword())) {
                        msgReturn = new MsgReturn(loginDto.getRank(), sys);
                    }
                }
        }
        return msgReturn;
    }

    public Map<String, Object> getLoginUser(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String userId = (String) request.getSession().getAttribute("nowUserSignature");
        Integer rank = (Integer) request.getSession().getAttribute("nowUserRank");
        if (userId != null && !("").equals(userId)) {
            switch (rank) {
                case 1:
                    map.put("user", studentService.getStuById(userId));
                    break;
                case 2:
                    map.put("user", auntService.getAuntById(userId));
                    break;
                case 3:
                    map.put("user", rearteachService.getRearById(userId));
                    break;
                case 4:
                    map.put("user", instructorService.getInstructorById(userId));
                    break;
            }
        }
        return map;
    }

    /**
     * 获取指定辅导员是否在线
     * @param iid      辅导员id
     * @param request  从session中获取在线情况
     */
    public boolean getInstructorOnLine(HttpServletRequest request, String iid) {

        String userId = (String) request.getSession().getAttribute("nowUserSignature");
        Integer rank = (Integer) request.getSession().getAttribute("nowUserRank");
        return userId != null && rank == 4;
    }
}
