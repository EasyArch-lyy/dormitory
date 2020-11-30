package com.data.dormitory.dto;

import java.util.HashMap;

public enum Rating {
    STU("学生",1),
    AUNT("宿管",2),
    COMMITTEE("寓管会",3),
    ASSISTANT("辅导员",4),
    SYSTEM("系统操作",5);
    private Rating(String key, Integer value) {
        this.key = key;
        this.value = value;
    }
    private String key;
    private Integer value;
    private static HashMap<Integer, Rating> valueMap = new HashMap<>();
    static {
        for (Rating item : Rating.values()) {
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
    public static Rating getByValue(Integer value) {
        Rating result = valueMap.get(value);
        if (result == null) {
            throw new IllegalArgumentException("No element matches " + value);
        }
        return result;
    }
}
