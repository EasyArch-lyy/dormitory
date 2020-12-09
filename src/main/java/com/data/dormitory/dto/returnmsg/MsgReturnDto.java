package com.data.dormitory.dto.returnmsg;

import com.data.dormitory.mbg.model.Aunt;
import com.data.dormitory.mbg.model.Instructor;
import com.data.dormitory.mbg.model.Rearteach;
import com.data.dormitory.mbg.model.Stu;

/**
 * 登录信息的返回值
 */
public class MsgReturnDto {

    /**学生身份信息*/
    private Stu stu;
    /**宿管身份信息*/
    private Aunt aunt;
    /**后勤身份信息*/
    private Rearteach rearteach;
    /**辅导员身份信息*/
    private Instructor instructor;
    /**系统用户信息*/
//    private Sys
    /**
     * 学院
     */
    private College college;
    /**
     * 专业
     */
    private Subject subject;
    /**
     * 身份
     */
    private Rating rating;
    /**
     * 性别
     */
    private Gender gender;
    /**
     * 等级编号
     */
    private Integer rank;

    private String signature;

    /**
     * 构造方法中判断
     * 返回值描述：
     * 所属身份的类，由数据库数字转换的内容
     */
    public MsgReturnDto(Integer rank, Object obj) {
        switch (rank) {
            case 1:
                this.stu = (Stu) obj;
                this.college = College.getByValue(stu.getCid());
                this.subject = Subject.getByValue(stu.getMid());
                this.gender = Gender.getByValue(stu.getSex());
                this.rating = Rating.getByValue(stu.getRank());
                this.rank = rank;
                this.signature = stu.getSid();
                break;
            case 2:
                this.aunt = (Aunt) obj;
                this.rating = Rating.getByValue(aunt.getRank());
                this.rank = rank;
                this.signature = aunt.getAid();
                break;
            case 3:
                this.rearteach = (Rearteach) obj;
                this.rating = Rating.getByValue(rearteach.getRank());
                this.gender = Gender.getByValue(rearteach.getSex());
                this.rank = rank;
                this.signature = rearteach.getTid();
                break;
            case 4:
                this.instructor = (Instructor) obj;
                this.rating = Rating.getByValue(instructor.getRank());
                this.gender = Gender.getByValue(instructor.getSex());
                this.signature = instructor.getIid();
                this.rank = rank;
                break;
            case 5:
                break;
        }
    }

    public Stu getStu() {
        return stu;
    }

    public Aunt getAunt() {
        return aunt;
    }

    public College getCollege() {
        return college;
    }

    public Subject getSubject() {
        return subject;
    }

    public Rating getRating() {
        return rating;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getRank() {
        return rank;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
