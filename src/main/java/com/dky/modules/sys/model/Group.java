package com.dky.modules.sys.model;

/**
 * describe:
 *
 * @author bowen
 * @date 2019/03/28
 */
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author bowen
 * @since 2019-04-07
 */
@TableName("a_base_group")
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 专家组编号
     */
    private Integer groupId;
    /**
     * 专家组名称
     */
    private String groupName;
    /**
     * 专家组组长ID
     */
    private Integer groupLeader;
    /**
     * 专家组秘书ID
     */
    private Integer groupSecretary;
    /**
     * 专家组成员ID
     */
    private Integer groupMember;
    /**
     * 答辩时间
     */
    private Date time;
    /**
     * 答辩地点
     */
    private String place;
    /**
     * 备注
     */
    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(Integer groupLeader) {
        this.groupLeader = groupLeader;
    }

    public Integer getGroupSecretary() {
        return groupSecretary;
    }

    public void setGroupSecretary(Integer groupSecretary) {
        this.groupSecretary = groupSecretary;
    }

    public Integer getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(Integer groupMember) {
        this.groupMember = groupMember;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ABaseGroup{" +
                ", id=" + id +
                ", groupId=" + groupId +
                ", groupName=" + groupName +
                ", groupLeader=" + groupLeader +
                ", groupSecretary=" + groupSecretary +
                ", groupMember=" + groupMember +
                ", time=" + time +
                ", place=" + place +
                ", remark=" + remark +
                "}";
    }
}
