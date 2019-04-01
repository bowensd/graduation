package com.dky.modules.mq.enums;

/**
 * describe:菜单枚举类
 *
 * @author unbesito
 * @date 2018/05/11
 */
public enum MenuEnum {


    DELETED_CODE("删除标识Key", "deleted_code", 0),
    P_ID("父ID KEY", "p_id", 0),

    /**
     * describe: 删除枚举类
     *
     * @author unbesito
     * @date 2018/5/11 13:44
     */
    DELETED("已删除", "1", 1),

    UNDELETED("未删除", "0", 0),

    /**
     * describe: 通用状态枚举类
     *
     * @author unbesito
     * @date 2018/5/11 13:50
     */
    ENABLE("启用", "1", 1),

    DISABLE("禁用", "0", 0),

    /**
     * describe: 菜单类型
     *
     * @author unbesito
     * @date 2018/5/11 14:04
     */
    TYPE_CATALOG("菜单组", "1", 1),

    TYPE_MENU("菜单", "2", 2);

    //TYPE_BUTTON("按钮","2",2);


    private String name;

    private Integer integerVal;

    private String stringVal;

    MenuEnum(String name, String stringVal, Integer integerVal) {
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
