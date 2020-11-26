package com.data.dormitory.mbg.model;

import java.io.Serializable;

public class Stu implements Serializable {
    /**
     * 学号
     *
     * @mbggenerated
     */
    private String sid;

    /**
     * 学院id
     *
     * @mbggenerated
     */
    private Integer cid;

    /**
     * 专业id
     *
     * @mbggenerated
     */
    private Integer mid;

    /**
     * 班级id
     *
     * @mbggenerated
     */
    private Integer gid;

    /**
     * 性别
     *
     * @mbggenerated
     */
    private Boolean sex;

    /**
     * 姓名
     *
     * @mbggenerated
     */
    private String sname;

    /**
     * 登录密码
     *
     * @mbggenerated
     */
    private String spasswd;

    /**
     * phone
     *
     * @mbggenerated
     */
    private String sphone;

    /**
     * 权限
     *
     * @mbggenerated
     */
    private Boolean rank;

    private static final long serialVersionUID = 1L;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpasswd() {
        return spasswd;
    }

    public void setSpasswd(String spasswd) {
        this.spasswd = spasswd;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public Boolean getRank() {
        return rank;
    }

    public void setRank(Boolean rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", cid=").append(cid);
        sb.append(", mid=").append(mid);
        sb.append(", gid=").append(gid);
        sb.append(", sex=").append(sex);
        sb.append(", sname=").append(sname);
        sb.append(", spasswd=").append(spasswd);
        sb.append(", sphone=").append(sphone);
        sb.append(", rank=").append(rank);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
