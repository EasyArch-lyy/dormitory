package com.data.dormitory.controller;

import com.data.dormitory.mbg.model.Aunt;
import com.data.dormitory.service.AuntService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auntController")
@Api(tags = "AuntController", description = "宿管信息")
public class AuntController {

    private static Logger LOGGER = LoggerFactory.getLogger(AuntController.class);

    @Autowired
    private AuntService auntService;

    /**
     * 根据id获取宿管
     */
    @RequestMapping(value = "/getAuntById",method = RequestMethod.GET)
    public Aunt getAuntById(@RequestParam("userId") String userId) {

        LOGGER.info("getAuntById() 调用");
        return auntService.getAuntById(userId);
    }
}
