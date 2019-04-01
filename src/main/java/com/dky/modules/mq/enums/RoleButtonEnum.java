package com.dky.modules.mq.enums;

public enum RoleButtonEnum {

    DELETED("删除状态","已删除",1),
    UNDELETED("删除状态","未删除",0),
    ROLE_ID("角色ID KEY", "role_id", 0),
    ROLEID("角色ID KEY", "roleId", 0),
    KEY("KEY", "key", 0);
    private String name;

    private Integer integerVal;

    private String stringVal;

    RoleButtonEnum(String name, String stringVal, Integer integerVal) {
        this.name = name;
        this.stringVal = stringVal;
        this.integerVal = integerVal;
    }

    public String getName() {
        return name;
    }

    public Integer getIntegerVal() {
        return integerVal;
    }

    public String getStringVal() {
        return stringVal;
    }
}
