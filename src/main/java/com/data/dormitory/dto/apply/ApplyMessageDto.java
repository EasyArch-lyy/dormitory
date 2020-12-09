package com.data.dormitory.dto.apply;

import com.data.dormitory.mbg.model.Askliveshort;

/**
 * 申请消息体
 */
public class ApplyMessageDto {

    private Integer kind;
    private Askliveshort ark;

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    public Askliveshort getAskliveshort() {
        return ark;
    }

    public void setAskliveshort(Askliveshort askliveshort) {
        this.ark = askliveshort;
    }
}
