package com.dky.modules.mq.enums;

/**
 * describe:分页枚举类
 *
 * @author unbesito
 * @date 2018/05/11
 */
public enum PageEnum {

    /**
    *describe: 菜单类型
    *@author unbesito
    *@date 2018/5/11 14:04
    */
    PAGEDMAXSIZE("每页默认数量","100000",100000),

    PAGESIZE("每页数量","PageSize",10),

    PAGENUM("第几数","PageNum",1);

    private String name;

    private Integer integerVal;

    private String stringVal;

    PageEnum(String name, String stringVal, Integer integerVal){
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
