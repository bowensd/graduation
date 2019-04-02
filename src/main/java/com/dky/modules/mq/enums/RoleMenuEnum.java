package com.dky.modules.mq.enums;

public enum RoleMenuEnum {

    ROLE_ID("角色ID KEY", "role_id", 0),
    ROLEID("角色ID KEY", "roleId", 0),
    MENUIDS("菜单ID数组 KEY", "menuIds", 0),
    MENU("菜单 KEY", "menu", 0),
    BUTTON("按钮 KEY", "button", 0);

    private String name;
    private Integer integerVal;
    private String stringVal;

    RoleMenuEnum(String name, String stringVal, Integer integerVal) {
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
