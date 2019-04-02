package com.dky.modules.mq.enums;

/**
 * describe:用户枚举类
 *
 * @author bowen
 * @date 2018/05/16
 */
public enum UserEnum {

    /**
    *describe: 性别枚举类
    *@author bowen
    *@date 2018/5/16 15:32
    */
    SEXMALE("男","1",1),
    SEXFEMALE("女","0",0),

    /**
     *describe: 同步状态枚举类
     *@author bowen
     *@date 2018/5/16 13:44
     */
    SYNCED("已同步","1",1),

    UNSYNCED("未同步","4",4),

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

    UserEnum(String name, String stringVal, Integer integerVal){
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
