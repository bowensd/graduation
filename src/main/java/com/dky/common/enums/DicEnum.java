package com.dky.common.enums;

public enum DicEnum {

    /**
    *describe: 超级管理员ID
    *@author bowen
    *@date 2018/5/11 14:05
    */
    SUPERADMIN("超级管理员","1314",1314),

    /**
    *describe: 删除枚举类
    *@author bowen
    *@date 2018/5/11 13:44
    */
    DELETED("已删除","1",1),

    UNDELETED("未删除","0",0),

    /**
    *describe: 通用状态枚举类
    *@author bowen
    *@date 2018/5/11 13:50
    */
    ENABLE("启用","1",1),

    DISABLE("禁用","0",0);



    private String name;

    private Integer integerVal;

    private String stringVal;

    DicEnum(String name, String stringVal, Integer integerVal){
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
