package com.data.dormitory.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class Punish implements Serializable {
    /**
     * 日期时间戳
     *
     * @mbggenerated
     */
    private Date date;

    /**
     * 楼号
     *
     * @mbggenerated
     */
    private Integer bid;

    /**
     * 床号
     *
     * @mbggenerated
     */
    private Integer bbid;

    /**
     * 宿舍号
     *
     * @mbggenerated
     */
    private Integer did;

    /**
     * 违纪类型
     *
     * @mbggenerated
     */
    private Byte kind;

    /**
     * 违纪描述
     *
     * @mbggenerated
     */
    private String descript;

    /**
     * 执勤宿管工号
     *
     * @mbggenerated
     */
    private String uid;

    private static final long serialVersionUID = 1L;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getBbid() {
        return bbid;
    }

    public void setBbid(Integer bbid) {
        this.bbid = bbid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Byte getKind() {
        return kind;
    }

    public void setKind(Byte kind) {
        this.kind = kind;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", date=").append(date);
        sb.append(", bid=").append(bid);
        sb.append(", bbid=").append(bbid);
        sb.append(", did=").append(did);
        sb.append(", kind=").append(kind);
        sb.append(", descript=").append(descript);
        sb.append(", uid=").append(uid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
