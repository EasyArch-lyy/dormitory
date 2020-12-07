package com.data.dormitory.controller;

import com.data.dormitory.api.CommonResult;
import com.data.dormitory.mbg.model.Instructor;
import com.data.dormitory.mbg.model.Rearteach;
import com.data.dormitory.service.SystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统权限下操作
 */
@RestController
@RequestMapping("/systemControl")
@Api(tags = "StudentController", description = "系统操作")
public class SystemController {

    private static Logger LOGGER = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    private SystemService systemService;

    /**
     * 系统创建后勤账号
     *
     * @param rearteach
     */
    @ApiOperation("创建后勤账号")
    @RequestMapping(value = "/createRearAccount", method = RequestMethod.POST)
    public CommonResult createRearAccount(@RequestBody Rearteach rearteach) {
        if (systemService.createRearAccount(rearteach) == 1) {
            LOGGER.info("插入后勤账号成功");
            return CommonResult.success(rearteach);
        } else {
            LOGGER.error("插入后勤账号失败");
            return CommonResult.failed();
        }
    }

    /**
     * 删除后勤账号
     */
    @ApiOperation("根据id删除后勤账号")
    @RequestMapping(value = "/delRearAccount", method = RequestMethod.GET)
    public CommonResult delRearAccount(@RequestParam("tid") String tid) {
        if (systemService.delRearAccount(tid) == 1) {
            LOGGER.info("删除后勤账号成功");
            return CommonResult.success(tid);
        } else {
            LOGGER.error("删除后勤账号失败");
            return CommonResult.failed();
        }
    }

    /**
     * 创建辅导员账号
     */
    @ApiOperation("创建辅导员账号")
    @RequestMapping(value = "/createInstructorAccount", method = RequestMethod.POST)
    public CommonResult createInstructorAccount(@RequestBody Instructor instructor) {
        if (systemService.createInstructorAccount(instructor) == 1) {
            LOGGER.info("创建辅导员账号成功");
            return CommonResult.success(instructor);
        } else {
            LOGGER.error("创建辅导员账号失败");
            return CommonResult.failed();
        }
    }

    /**
     * 根据id删除辅导员账号
     */
    @ApiOperation("根据id删除辅导员账号")
    @RequestMapping(value = "/delInstructorById", method = RequestMethod.GET)
    public CommonResult delInstructorById(@RequestParam("iid") String iid) {
        if (systemService.delInstructorById(iid) == 1) {
            LOGGER.info("删除辅导员账号成功");
            return CommonResult.success(iid);
        } else {
            LOGGER.error("删除辅导员账号失败");
            return CommonResult.failed();
        }
    }
}
