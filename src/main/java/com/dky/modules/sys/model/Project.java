package com.dky.modules.sys.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * describe:
 *
 * @author bowen
 * @date 2019/04/07
 */
@TableName("a_base_project")
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Integer id;
    /**
     * 课题名称
     */
    private String name;
    /**
     * 题目类型
     */
    private String type;
    /**
     * 题目来源
     */
    private String source;
    /**
     * 工作量
     */
    private String workload;
    /**
     * 困难度
     */
    private String difficulty;
    /**
     * 题目简介
     */
    private String introduce;
    /**
     * 毕业设计要求
     */
    private String requirement;
    /**
     * 主要参考资料
     */
    private String reference;
    /**
     * 课题适用专业
     */
    private String major;
    /**
     * 附件
     */
    private String appendix;

    private Integer deletedCode;

    private String deletedName;

    private Integer stateCode;

    private String stateName;

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Integer getDeletedCode() {
        return deletedCode;
    }

    public void setDeletedCode(Integer deletedCode) {
        this.deletedCode = deletedCode;
    }

    public String getDeletedName() {
        return deletedName;
    }

    public void setDeletedName(String deletedName) {
        this.deletedName = deletedName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getWorkload() {
        return workload;
    }

    public void setWorkload(String workload) {
        this.workload = workload;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAppendix() {
        return appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", source='" + source + '\'' +
                ", workload='" + workload + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", introduce='" + introduce + '\'' +
                ", requirement='" + requirement + '\'' +
                ", reference='" + reference + '\'' +
                ", major='" + major + '\'' +
                ", appendix='" + appendix + '\'' +
                ", deletedCode=" + deletedCode +
                ", deletedName='" + deletedName + '\'' +
                ", stateCode=" + stateCode +
                ", stateName='" + stateName + '\'' +
                '}';
    }
}
