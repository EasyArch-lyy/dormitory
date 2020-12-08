package com.data.dormitory.controller;

import com.data.dormitory.api.CommonResult;
import com.data.dormitory.dto.returnmsg.LoginDto;
import com.data.dormitory.mbg.model.Stu;
import com.data.dormitory.service.AuntService;
import com.data.dormitory.service.InstructorService;
import com.data.dormitory.service.LoginService;
import com.data.dormitory.service.RearteachService;
import com.data.dormitory.service.StudentService;
import com.data.dormitory.service.UserOnLineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "loginController", description = "用户登录类")
@RestController
@RequestMapping("/account")
public class LoginController {

    private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserOnLineService userOnLineService;

    /**
     * 用户登录
     * 权限rank  1学生,2宿管,3管理层,4辅导员,5系统维护账号
     */
    @ApiOperation("用户登录校验")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(HttpServletRequest request, @RequestBody LoginDto loginDto) {

        LOGGER.info("login() 调用");
        Object obj = loginService.login(loginDto);
        if (obj != null) {
            userOnLineService.addOnlineSession(request, obj);
            LOGGER.info("登录成功");
            return CommonResult.success(obj);
        } else {
            LOGGER.error("登录失败");
            return CommonResult.failed();
        }
    }

    /**
     * 用户登出
     */
    @ApiOperation("用户登出")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public CommonResult logout(HttpServletRequest request) {

        synchronized (request.getSession()) {
            String userId = (String) request.getSession().getAttribute("nowUserSignature");
            if (userId != null) {
                request.getSession().removeAttribute("nowUserSignature");
                request.getSession().removeAttribute("nowUserRank");
                return CommonResult.success("success");
            } else {
                return CommonResult.failed();
            }
        }
    }

    /**
     * 获取当前登录用户
     */
    @ApiOperation("获取当前登录用户")
    @RequestMapping(value = "/getLoginUser", method = RequestMethod.GET)
    public Map<String, Object> getLoginUser(HttpServletRequest request) {

        return loginService.getLoginUser(request);
    }

    /**
     * 查询对应的辅导员是否在线
     */

}
