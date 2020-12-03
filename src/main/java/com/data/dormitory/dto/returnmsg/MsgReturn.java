package com.data.dormitory.dto.returnmsg;

import com.data.dormitory.mbg.model.Aunt;
import com.data.dormitory.mbg.model.Stu;

/**
 * 登录信息的返回值
 */
public class MsgReturn {


    private Stu stu;
    private Aunt aunt;
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

    /**
     * 构造方法中判断
     * 返回值描述：
     * 所属身份的类，由数据库数字转换的内容
     */
    public MsgReturn(Integer rank, Object obj) {
        switch (rank) {
            case 1:
                this.stu = (Stu) obj;
                this.college = College.getByValue(stu.getCid());
                this.subject = Subject.getByValue(stu.getMid());
                this.gender = Gender.getByValue(stu.getSex());
                this.rating = Rating.getByValue(stu.getRank());
                this.rank = rank;
                break;
            case 2:
                this.aunt = (Aunt) obj;
                this.rating = Rating.getByValue(aunt.getRank());
                this.rank = rank;
                break;
            case 3:
                break;
            case 4:
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
}
