package com.data.dormitory.controller;

import com.data.dormitory.api.CommonResult;
import com.data.dormitory.mbg.model.Askliveshort;
import com.data.dormitory.service.ApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;

/**
 * 学生提交申请类
 */
@RestController
@RequestMapping("/applyMsg")
@Api(tags = "applyController", description = "学生提交申请类")
public class ApplyController {

    private static Logger LOGGER = LoggerFactory.getLogger(ApplyController.class);

    @Autowired
    private ApplyService applyService;

    /**
     * 提交请假申请
     */
    @ApiOperation("提交离校请假申请")
    @RequestMapping(value = "/aplyLeave", method = RequestMethod.POST)
    public CommonResult aplyLeave(@RequestBody Askliveshort askliveshort, HttpServletRequest request) throws ParseException {

        String[] msg = applyService.aplyLeave(askliveshort, request);
        if (msg[0].equals(1)) {
            LOGGER.info("插入请假申请成功");
            return CommonResult.success(askliveshort);
        } else {
            LOGGER.error("插入请假申请失败");
            return CommonResult.failed("申请时间已过22点");
        }
    }

    /**
     * 紧急申请(特殊时间段或者特殊情况申请
     */

    /**
     * 通知审批
     */
//    @RequestMapping(value = "/noticeApprove", method = RequestMethod.GET)
//    public CommonResult noticeApprove()
}
