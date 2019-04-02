package com.dky.modules.mq.enums;

public enum RoleUserEnum {

    ROLE_ID("角色ID KEY", "role_id", 0),
    USER_ID("用户ID KEY", "user_id", 0),
    USERIDS("用户ID数组 KEY", "userIds", 0);
    private String name;
    private Integer integerVal;
    private String stringVal;

    RoleUserEnum(String name, String stringVal, Integer integerVal) {
        this.name = name;
        this.stringVal = stringVal;
        this.integerVal = integerVal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIntegerVal() {
        return integerVal;
    }

    public void setIntegerVal(Integer integerVal) {
        this.integerVal = integerVal;
    }

    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }
}
