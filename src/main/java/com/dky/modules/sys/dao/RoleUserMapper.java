package com.dky.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dky.modules.sys.model.RoleUser;
import com.dky.modules.sys.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
*describe: 角色用户
*
*@author bowen
*@date 2018/5/23 16:56
*/
@Mapper
public interface RoleUserMapper extends BaseMapper<RoleUser> {
    @Select("SELECT " +
            " * " +
            "FROM " +
            " a_base_user u " +
            "INNER JOIN a_base_role_user ru ON ru.user_id = u.id " +
            "WHERE " +
            " ru.role_id = #{roleId} ")
    List<User> getRoleUserList(@Param("roleId") String roleId);
}
