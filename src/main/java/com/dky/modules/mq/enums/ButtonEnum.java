package com.dky.modules.mq.enums;

/**
*describe: 按钮枚举类
*
*@author bowen
*@date 2018/5/24 14:25
*/
public enum ButtonEnum {

    DELETED_CODE("删除标识Key", "deleted_code", 0),
    MENU_ID("菜单ID KEY","menu_id",0),
    MENUID("菜单ID KEY","menuId",0),
    /**
    *describe: 删除枚举类
    *@author bowen
    *@date 2018/5/24
    */
    DELETED("已删除","1",1),

    UNDELETED("未删除","0",0),

   /**
   *describe: 通用状态枚举类
   *@author bowen
   *@date 2018/5/24
   */
    ENABLE("启用","1",1),

    DISABLE("禁用","0",0);


    private String name;

    private Integer integerVal;

    private String stringVal;

    ButtonEnum(String name, String stringVal, Integer integerVal){
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
