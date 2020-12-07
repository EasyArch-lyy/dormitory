package com.data.dormitory.controller;

import com.data.dormitory.api.CommonResult;
import com.data.dormitory.mbg.model.HygieneNum;
import com.data.dormitory.mbg.model.Punish;
import com.data.dormitory.service.MsgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 加扣分情况及违纪获取控制
 */
@RestController
@Api(tags = "msgController", description = "扣分及违纪记录登记")
@RequestMapping("/msgController")
public class MsgController {

    private static Logger LOGGER = LoggerFactory.getLogger(MsgController.class);

    @Autowired
    private MsgService msgService;

    /**
     * 学生违纪信息填入
     */
    @ApiOperation("学生违纪信息填入")
    @RequestMapping(value = "/addPunish", method = RequestMethod.POST)
    public CommonResult addPunish(@RequestBody Punish punish) {

        LOGGER.info("addPunish() 调用");
        if (msgService.addPunish(punish) == 1) {
            LOGGER.info("违纪信息插入成功");
            return CommonResult.success("插入成功");
        } else {
            LOGGER.error("违纪信息插入失败");
            return CommonResult.failed("插入失败");
        }
    }

    /**
     * 人工登记填入
     */
    @ApiOperation("人工登记填入")
    @RequestMapping(value = "/addHygiene", method = RequestMethod.POST)
    public CommonResult addHygiene(@RequestBody HygieneNum hygieneNum) {

        LOGGER.info("addHygiene() 调用");
        if (msgService.addHygiene(hygieneNum) == 1) {
            LOGGER.info("人工检查信息插入成功");
            return CommonResult.success("插入成功");
        } else {
            LOGGER.error("人工检查信息插入失败");
            return CommonResult.failed("人工检查信息插入失败");
        }
    }
}
