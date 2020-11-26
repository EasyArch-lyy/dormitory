package com.data.dormitory.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class Leave implements Serializable {
    /**
     * 自增id
     *
     * @mbggenerated
     */
    private Integer id;

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
     * 床位号
     *
     * @mbggenerated
     */
    private Boolean bbid;

    /**
     * 请假类型
     *
     * @mbggenerated
     */
    private Boolean kind;

    /**
     * 开始时间戳
     *
     * @mbggenerated
     */
    private Date begindate;

    /**
     * 结束时间戳
     *
     * @mbggenerated
     */
    private Date overdate;

    /**
     * 审批人id
     *
     * @mbggenerated
     */
    private String uid;

    /**
     * 审批状态
     *
     * @mbggenerated
     */
    private Boolean reviewstate;

    /**
     * 请假明细
     *
     * @mbggenerated
     */
    private String descript;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getBbid() {
        return bbid;
    }

    public void setBbid(Boolean bbid) {
        this.bbid = bbid;
    }

    public Boolean getKind() {
        return kind;
    }

    public void setKind(Boolean kind) {
        this.kind = kind;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getOverdate() {
        return overdate;
    }

    public void setOverdate(Date overdate) {
        this.overdate = overdate;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Boolean getReviewstate() {
        return reviewstate;
    }

    public void setReviewstate(Boolean reviewstate) {
        this.reviewstate = reviewstate;
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
        sb.append(", id=").append(id);
        sb.append(", bid=").append(bid);
        sb.append(", did=").append(did);
        sb.append(", bbid=").append(bbid);
        sb.append(", kind=").append(kind);
        sb.append(", begindate=").append(begindate);
        sb.append(", overdate=").append(overdate);
        sb.append(", uid=").append(uid);
        sb.append(", reviewstate=").append(reviewstate);
        sb.append(", descript=").append(descript);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
