package com.data.dormitory.controller;

import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
/**
 * 记录在线用户
 */
@RestController
@RequestMapping("/userOnLineController")
public class UserOnLineController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserOnLineController.class);
// 特征码
//    @RequestMapping(value = "/addOnlineSession")
//    public String addOnlineSession(HttpServletRequest request, @RequestParam String name, @RequestParam String pwd) {
//
//    }


}
