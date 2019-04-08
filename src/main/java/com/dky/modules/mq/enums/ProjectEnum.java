package com.dky.modules.mq.enums;

/**
 * describe:
 *
 * @author bowen
 * @date 2019/04/07
 */
public enum ProjectEnum {

    STATE_CODE("状态码，1：已选择，0：未选择","state_code",0),
    DELETED_CODE("删除标识Key", "deleted_code", 0),

    /**
     * describe: 删除枚举类
     *
     * @author unbesito
     * @date 2018/5/11 13:44
     */
    DELETED("已删除", "1", 1),

    UNDELETED("未删除", "0", 0),

    /**
     * 状态枚举类
     */
    SELECTED("已选择","1",1),

    UNSELECTED("未选择","0",0);


    private String name;

    private Integer integerVal;

    private String stringVal;

    ProjectEnum(String name, String stringVal, Integer integerVal) {
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
