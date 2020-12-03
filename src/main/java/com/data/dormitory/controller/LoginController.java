package com.data.dormitory.controller;

import com.data.dormitory.api.CommonResult;
import com.data.dormitory.dto.returnmsg.LoginDto;
import com.data.dormitory.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "loginController", description = "用户登录类")
@RestController
@RequestMapping("/api/login")
public class LoginController {

    private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    /**
     * 用户登录
     * 权限rank  1学生,2宿管,3管理层,4辅导员,5系统维护账号
     */
    @ApiOperation("用户登录校验")
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public CommonResult login(@RequestBody LoginDto loginDto) {

        LOGGER.info("login() 调用");
        Object obj = loginService.login(loginDto);
        if (obj != null) {
            LOGGER.info("登录成功");
            return CommonResult.success(obj);
        } else {
            LOGGER.error("登录失败");
            return CommonResult.failed();
        }
    }
}
