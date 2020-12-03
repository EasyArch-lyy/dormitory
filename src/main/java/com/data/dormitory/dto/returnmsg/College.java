package com.data.dormitory.dto.returnmsg;

import java.util.HashMap;
/**
 * 学院枚举类
 */
public enum College {

    TECHNOLOGY("机械", 1),SOFTWARE("软件", 2),HOTEL("网络", 3);

    private String key;
    private Integer value;
    private College(String key, Integer value) {
        this.key = key;
        this.value = value;
    }
    private static HashMap<Integer,College> valueMap = new HashMap<>();
    static {
        for (College item : College.values()) {
            valueMap.put(item.getValue(), item);
        }
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
    public static College getByValue(Integer value) {
        College college = valueMap.get(value);
        if (college == null) {
            throw new IllegalMonitorStateException("No element matches " + value);
        }
        return college;
    }
}
