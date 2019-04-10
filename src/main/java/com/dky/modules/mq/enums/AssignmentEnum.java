package com.dky.modules.mq.enums;

/**
 * describe:
 *
 * @author bowen
 * @date 2019/04/09
 */
public enum  AssignmentEnum {
    TEACHER_ID("教师ID","teacher_id",0),
    STUDENT_ID("学生ID","student_id",0);

    private String name;

    private Integer integerVal;

    private String stringVal;

    AssignmentEnum(String name, String stringVal, Integer integerVal) {
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
