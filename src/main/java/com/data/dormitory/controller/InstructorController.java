package com.data.dormitory.controller;

import com.data.dormitory.mbg.model.Instructor;
import com.data.dormitory.service.InstructorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/*
*
* 用户A给B发送一条消息，B不在线，离线消息存储的流程如下:
1.A发送消息给B,通过服务器server中转;

2.server查看B的状态为offline离线；（服务端会缓存用户的状态）

3.server将消息存储到数据库DB;

4.server返回用户A,消息发送成功；（对于发送方而言，消息存到DB，就认为发送成功）

用户B上线了，他要拉取A给他发送的离线消息，整体流程如下：

1.B向server拉取A给B发送的离线消息；  （通过uid_B,uid_A在离线消息表查询）

2.server从DB中获取离线消息；

3.server从DB中删除离线消息；

4.server将B所需要的离线消息返回给B.
* */
@RestController
@RequestMapping("/instructorController")
@Api(tags = "instructorController", description = "辅导员信息及行为")
public class InstructorController {

    private static Logger LOGGER = LoggerFactory.getLogger(InstructorController.class);

    @Autowired
    private InstructorService instructorService;

    @ApiOperation("根据工号获取辅导员信息")
    @RequestMapping(value = "/getInstructorById", method = RequestMethod.GET)
    public Instructor getInstructorById(@RequestParam(value = "iid") String iid) {
        return instructorService.getInstructorById(iid);
    }

    @ApiOperation("根据专业班级获取辅导员信息")
    @RequestMapping(value = "/getInstructorByMGid", method = RequestMethod.GET)
    public Instructor getInstructorByMGid(@RequestParam(value = "mid") Integer mid,
                                          @RequestParam(value = "gid") Integer gid) {

        return instructorService.getInstructorByMGid(mid, gid);
    }

    /**
     * 根据辅导员id(key)从redis提取获取离线期间堆积的申请(value)
     *
     * @param iid 辅导员工号
     */
    @ApiOperation("获取相关申请")
    @RequestMapping(value = "/getApply", method = RequestMethod.GET)
    public List<Object> getApplys(@RequestParam(value = "iid") String iid) {

        return instructorService.getApply(iid);
    }

    /**
     * 辅导员对申请操作
     *
     * @param id      处理的申请id
     * @param operate 对申请的处理
     */
    @ApiOperation("辅导员对申请操作")
    @RequestMapping(value = "/operateApply", method = RequestMethod.GET)
    public boolean operateApply(@RequestParam(value = "id") Integer id,
                                @RequestParam(value = "operate") boolean operate) {

        return instructorService.operateApply(id, operate);
    }

}
