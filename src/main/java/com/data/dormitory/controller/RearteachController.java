package com.data.dormitory.controller;

import com.data.dormitory.api.CommonResult;
import com.data.dormitory.mbg.model.Rearteach;
import com.data.dormitory.service.RearteachService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/RearteachController")
@Api(tags = "msgController", description = "后勤信息获取类")
public class RearteachController {

    private static Logger LOGGER = LoggerFactory.getLogger(RearteachController.class);

    @Autowired
    private RearteachService rearteachService;

    @RequestMapping(value = "/getRearById", method = RequestMethod.GET)
    public Rearteach getRearById(@RequestParam("tid") String tid) {
        LOGGER.info("getRearById() 调用");
        return rearteachService.getRearById(tid);
    }
}
