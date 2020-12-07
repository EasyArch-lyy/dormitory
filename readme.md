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
char(20)|int(2)|int(3)|int(1)|int(1)

######卫生扣分表·hygiene_num
`date`时间戳| `bid`楼号|`did`宿舍号 |`grade`扣除分数|`descript`扣分描述|
----|----|----|----|----|
timestamp|int(2)|int(2)|int(2)|varchar(255)

######违纪表  ·punish
`bid`楼号|`bbid`床号|`did`宿舍号|`kind`违纪类型|`descript`违纪描述|`date`日期时间戳|`uid`执勤宿管工号|
----|----|----|----|----|----|----|
int(2)|int(1)|int(3)|int(2)|varchar(255)|timestamp|char(20)|

######学生信息表    ·stu   
`sid`学号|`cid`学院id|`mid`专业id|`gid`班级id|`sex`性别|`sname`姓名|`spasswd`登录密码|`sphone`phone|`rank`权限等级|
----|----|----|----|----|----|----|----|----|
char(20)|int(2)|int(3)|int(4)|int(2)|char(10)|varchar(50)|char(20)|int(1)

######宿管信息表   ·aunt
`aid`工号|`bid`楼号|`aname`姓名|`apasswd`登录密码|`aphone`phone|`rank`权限|
----|----|----|----|----|----|
char(20)|int(1)|char(10)|char(20)|char(20)|int(1)|

(系统账号存在后勤教师表)
######后勤教师表 ·rearteach
`tid`教师工号|`bid`管理的宿舍楼|`sex`性别|`tname`姓名|`tphone`电话|`tpasswd`登录密码|`rank`权限等级
----|----|----|----|----|----|----|
char(11)|int(2)|int(1)|varchar(20)|char(25)|char(25)|int(1)
######系统账号 ·sysuser
`tid`登录账号|`tpasswd`密码|`rank`权限等级|
----|----|----|

######辅导员信息表·instructor
`iid`辅导员工号|`cid`学院|`mid`专业|`gid`班级id|`sex`性别|`iname`姓名|`ipasswd`登录密码|`iphone`电话|`rank`权限等级
----|----|----|----|----|----|----|----|----|
char(11)|int(1)|int(2)|int(4)|int(1)|char(25)|char(25)|char(11)|int(1)

######短时离校请假表 ·askliveshort
`currstamp`当前时间戳|`sid`学号|`bid`宿舍楼号|`did`宿舍号|`bbid`学生床位号|`aplykind`请假类型(晚归、不归|`reason`理由|`datestart`开始时间戳|`dataend`结束时间戳|`assign`审批人|`asssignstate`审批状态
----|----|----|----|----|----|----|----|----|----|----|
timestamp(6)|char(11)|int(2)|int(3)|int(1)|int(1)|varchar(500)|timestamp|timestamp|char(11)|int(1)


权限rank  1学生,2宿管,3管理层,4辅导员,sys系统维护账号
