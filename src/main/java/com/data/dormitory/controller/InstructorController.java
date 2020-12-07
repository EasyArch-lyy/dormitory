package com.data.dormitory.controller;

import com.data.dormitory.mbg.model.Instructor;
import com.data.dormitory.service.InstructorService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instructorController")
@Api(tags = "instructorController", description = "辅导员信息")
public class InstructorController {

    private static Logger LOGGER = LoggerFactory.getLogger(InstructorController.class);

    @Autowired
    private InstructorService instructorService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Instructor getInstructorById(@RequestParam(value = "iid") String iid) {
        return instructorService.getInstructorById(iid);
    }
}
