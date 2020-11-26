package com.data.dormitory.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class HygieneNum implements Serializable {
    /**
     * 时间戳
     *
     * @mbggenerated
     */
    private Date date;

    /**
     * 楼号
     *
     * @mbggenerated
     */
    private Byte bid;

    /**
     * 宿舍号
     *
     * @mbggenerated
     */
    private Byte did;

    /**
     * 扣除分数
     *
     * @mbggenerated
     */
    private Byte grade;

    /**
     * 扣分描述
     *
     * @mbggenerated
     */
    private String descript;

    private static final long serialVersionUID = 1L;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Byte getBid() {
        return bid;
    }

    public void setBid(Byte bid) {
        this.bid = bid;
    }

    public Byte getDid() {
        return did;
    }

    public void setDid(Byte did) {
        this.did = did;
    }

    public Byte getGrade() {
        return grade;
    }

    public void setGrade(Byte grade) {
        this.grade = grade;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", date=").append(date);
        sb.append(", bid=").append(bid);
        sb.append(", did=").append(did);
        sb.append(", grade=").append(grade);
        sb.append(", descript=").append(descript);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
