package com.data.dormitory.mbg.model;

import java.io.Serializable;

public class BedSid implements Serializable {
    /**
     * 学号
     *
     * @mbggenerated
     */
    private String sid;

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
     * 床号
     *
     * @mbggenerated
     */
    private Boolean bbid;

    /**
     * 是否宿舍长
     *
     * @mbggenerated
     */
    private Boolean chief;

    private static final long serialVersionUID = 1L;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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

    public Boolean getChief() {
        return chief;
    }

    public void setChief(Boolean chief) {
        this.chief = chief;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", bid=").append(bid);
        sb.append(", did=").append(did);
        sb.append(", bbid=").append(bbid);
        sb.append(", chief=").append(chief);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
