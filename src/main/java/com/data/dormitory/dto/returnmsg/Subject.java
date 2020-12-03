package com.data.dormitory.dto.returnmsg;

import java.util.HashMap;
/**
 * 专业枚举
 */
public enum Subject {
    TECHNOLOGY("计算机", 1), SOFTWARE("软件", 2), NETWORK("网络", 3),EDUCATION("教技",4);
    private String key;
    private Integer value;
    private Subject(String key, Integer value) {
        this.key = key;
        this.value = value;
    }
    private static HashMap<Integer, Subject> valueMap = new HashMap<>();
    static {
        for (Subject item : Subject.values()) {
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
    public static Subject getByValue(Integer value) {
        Subject subject = valueMap.get(value);
        if (subject == null) {
            throw  new IllegalMonitorStateException("No element matches " + value);
        }
        return subject;
    }
}
