package com.dky.modules.mq.enums;

/**
 * describe:角色枚举类
 *
 * @author bowen
 * @date 2018/5/24
 */
public enum RoleEnum {


    DELETED_CODE("删除标识Key", "deleted_code", 0),
    P_ID("父ID KEY", "p_id", 0),
    NAME("名称", "name", 0),
    SYNC_CODE("同步标识KEY", "sync_code", 0),
    STATE_CODE("状态标识KEY", "state_code", 0),
    SORT_INDEX("排序标识KEY", "sort_index", 0),
    TYPE("类型KEY", "type", 0),
    /**
     * describe:同步状态枚举类
     *
     * @author bowen
     * @date 2018/5/24
     */
    SYNCED("已同步", "1", 1),

    UNSYNCED("未同步", "0", 0),

    /**
     * describe:删除枚举类
     *
     * @author bowen
     * @date 2018/5/24
     */
    DELETED("已删除", "1", 1),

    UNDELETED("未删除", "0", 0),

    /**
     * describe:通用状态枚举类
     *
     * @author bowen
     * @date 2018/5/24
     */
    ENABLE("启用", "1", 1),

    DISABLE("禁用", "0", 0);

    private String name;
    private Integer integerVal;
    private String stringVal;

    RoleEnum(String name, String stringVal, Integer integerVal) {
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
