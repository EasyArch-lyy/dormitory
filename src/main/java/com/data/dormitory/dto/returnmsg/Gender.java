package com.data.dormitory.dto.returnmsg;

import java.util.HashMap;
/**
 * 性别枚举类
 */
public enum Gender {
    MALE("男", 1), FAMALE("女", 2);
    private String key;
    private Integer value;
    private Gender(String key, Integer value) {
        this.key = key;
        this.value = value;
    }
    private static HashMap<Integer, Gender> valueMap = new HashMap<>();
    static {
        for (Gender item : Gender.values()) {
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
    public static Gender getByValue(Integer value) {
        Gender result = valueMap.get(value);
        if(result == null) {
            throw new IllegalArgumentException("No element matches " + value);
        }
        return result;
    }
}
