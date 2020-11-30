package com.data.dormitory.controller;

import com.data.dormitory.api.CommonResult;
import com.data.dormitory.mbg.model.BedSid;
import com.data.dormitory.mbg.model.HygieneNum;
import com.data.dormitory.mbg.model.Punish;
import com.data.dormitory.mbg.model.Stu;
import com.data.dormitory.mbg.model.TestLogin;
import com.data.dormitory.service.StudentService;
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

@RestController
@RequestMapping("/studentController")
@Api(tags = "StudentController", description = "学生信息")
/**
 * 学生信息访问类
 */
public class StudentController {

    private static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    /**
     * 根据id获取用户
     */
    @ApiOperation("根据学号获取学生")
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public Stu getUser(@RequestParam("userId") String userId) {

        LOGGER.info("getUser() 调用");
        return studentService.getUserById(userId);
    }

    /**
     * 验证用户登录
     */
    @ApiOperation("验证学生登录")
    @RequestMapping(value = "/getLogin", method = RequestMethod.POST)
    public CommonResult getLogin(@RequestBody Stu stu) {

        LOGGER.info("getLogin() 调用");
        stu = studentService.getLogin(stu.getSid(), stu.getSpasswd());
        if (stu == null) {
            LOGGER.error("验证失败");
            return CommonResult.failed();
        } else {
            LOGGER.info("验证成功");
            return CommonResult.success(stu);
        }
    }

    /**
     * 床位匹配
     *
     * @param sid 学号
     */
    @ApiOperation("根据学号获取")
    @RequestMapping(value = "/getBedId", method = RequestMethod.GET)
    public CommonResult getBedId(@RequestParam("sid") String sid) {

        LOGGER.info("getBedId() 调用");
        BedSid bedSid = studentService.getBedId(sid);
        if (bedSid == null) {
            LOGGER.error("根据学号获取床位失败");
            return CommonResult.failed("获取床位失败");
        } else {
            LOGGER.info("根据学号获取床位成功");
            return CommonResult.success(bedSid);
        }
    }

    /**
     * 根据床号匹配学生
     * @param bid  楼号
     * @param did  宿舍号
     * @param bbid 床号
     */
    @ApiOperation("根据床号获取学生")
    @RequestMapping(value = "/getStu", method = RequestMethod.GET)
    public CommonResult getStu(@RequestParam("bid") Integer bid,
                               @RequestParam("did") Integer did,
                               @RequestParam("bbid") Integer bbid) {

        LOGGER.info("getStu() 调用");
        Stu s = studentService.getStu(bid, did, bbid);
        if (s == null) {
            LOGGER.error("根据床号获取学生失败");
            return CommonResult.failed();
        }else {
            LOGGER.info("根据床号获取学生成功");
            return CommonResult.success(s);
        }
    }
}
