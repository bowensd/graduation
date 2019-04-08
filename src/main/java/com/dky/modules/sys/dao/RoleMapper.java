package com.dky.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dky.modules.sys.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

/**
*describe:角色
*
*@author bowen
*@date 2018/5/23 16:56
*/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("SELECT " +
            " role.id as id, " +
            " role.p_id as pId, " +
            " role.sync_code as syncCode, " +
            " role.sync_name as syncName, " +
            " role.state_code as stateCode, " +
            " role.state_name as stateName, " +
            " role.deleted_code as deletedCode, " +
            " role.deleted_name as deletedName, " +
            " role.sort_index as sortIndex, " +
            " role.type, " +
            " role.remark, " +
            " role.name, " +
            " count(ru.role_id) as userNum, " +
            " count( rb.role_id ) AS buttonNum " +
            "FROM " +
            " a_base_role role " +
            " LEFT JOIN a_base_role_user ru ON ru.role_id = role.id " +
            " LEFT JOIN a_base_role_button rb ON rb.role_id = role.id " +
            " WHERE role.deleted_code=#{deletedCode} " +
            " GROUP BY role.id ")
    List<Map<String,Object>> listNew(Page<Map<String, Object>> page, @Param("role") Role role, @Param("deletedCode") Integer deletedCode);
}
