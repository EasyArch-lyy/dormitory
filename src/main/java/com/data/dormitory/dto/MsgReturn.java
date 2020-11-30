package com.data.dormitory.dto;

import com.data.dormitory.mbg.model.Stu;

/**
 * 登录信息的返回值
 */
public class MsgReturn {

    private Stu stu;
    private College college;
    private Subject subject;
    private Rating rating;
    private Gender gender;

    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege() {
        this.college = College.getByValue(stu.getCid());
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject() {
        this.subject = Subject.getByValue(stu.getGid());
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating() {
        this.rating = Rating.getByValue(stu.getRank());
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender() {
        this.gender = Gender.getByValue(stu.getSex());
    }
}
