mbg -------mybatis生成 \
logs  按日期存放info.log   error.log

业务流程：


学生提交申请出校表  -->  提交辅导员

辅导员审批         <-   审批结果反馈学生              

系统查宿流程-----------
超时禁止申请 、 审批超时

##数据表  

######床位和学号对应表·bed_sid

`sid`学号 | `bid` 楼号|`did`宿舍号|`bbid`床号|`chief` 是否宿舍长|
----|----|----|----|----|

######卫生扣分表·hygiene_num
`date`时间戳| `bid`楼号|`did`宿舍号 |`grade`扣除分数|`descript`扣分描述|
----|----|----|----|----|
timestamp|int(2)|int(2)|int(2)|varchar(255)

######请假记录表·leave
`id`自增id|`bid`楼号|`did`宿舍号|`bbid`床位号|`kind`请假类型|`begindate`开始时间戳|`overdate`结束时间戳|`uid`审批人id|`reviewstate`审批状态|`descript`|
----|----|----|----|----|----|----|----|----|----|
int(5)|int(2)|int(3)|int(1)|int(1)|timestamp|timestamp|char(20)|int(1)|varchar(255)请假明细|

######违纪表  ·punish
`bid`楼号|`bbid`床号|`did`宿舍号|`kind`违纪类型|`descript`违纪描述|`date`日期时间戳|`uid`执勤宿管工号|
----|----|----|----|----|----|----|
int(2)|int(1)|int(3)|int(2)|varchar(255)|timestamp|char(20)|

######学生信息表    ·stu   
`sid`学号|`cid`学院id|`mid`专业id|`gid`班级id|`sex`性别|`sname`姓名|`spasswd`登录密码|`sphone`phone|`rank`权限|
----|----|----|----|----|----|----|----|----|
char(20)|int(2)|int(3)|int(4)|int(2)|char(10)|varchar(50)|char(20)|int(1)


######宿管信息表   ·aunt
`aid`工号|`bid`楼号|`aname`姓名|`apasswd`登录密码|`aphone`phone|`rank`权限|
----|----|----|----|----|----|
char(20)|int(1)|char(10)|char(20)|char(20)|int(1)|

######短时离校请假表 ·askliveshort
`timestamp`当前时间戳|`sid`学号|`bid`宿舍楼号|`dormitory`宿舍号|`bbid`学生床位号|`aplykind`请假类型(晚归、不归|`reason`理由|`datestart`开始时间戳|`dataend`结束时间戳|`assign`审批人|`asssignstate`审批状态
----|----|----|----|----|----|----|----|----|----|----|
timestamp|char(11)|


权限rank  1学生,2宿管,3管理层,4辅导员,sys系统维护账号
