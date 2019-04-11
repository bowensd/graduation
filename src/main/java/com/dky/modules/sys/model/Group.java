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
     * 答辩成员ID号
     */
    private Integer memberId;
    /**
     * 角色ID,1:学生，2：答辩教师，3：答辩秘书，4：答辩组长
     */
    private Integer roleCode;
    /**
     * 角色名
     */
    private String roleName;

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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(Integer roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", memberId=" + memberId +
                ", roleCode=" + roleCode +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
