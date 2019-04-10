package com.dky.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dky.modules.sys.model.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
*describe: 菜单
*
*@author bowen
*@date 2018/5/23 11:29
*/
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    @Select("SELECT " +
            " menu.* " +
            "FROM  " +
            " a_base_menu menu " +
            "INNER JOIN a_base_role_menu rm ON rm.menu_id = menu.id " +
            "INNER JOIN a_base_role_user ru ON ru.role_id = rm.role_id " +
            "INNER JOIN a_base_user u on u.id = ru.user_id " +
            "WHERE u.name=#{userName} " +
            "GROUP BY menu.id ")
    List<Menu> menuListByUserName(@Param("userName") String userName);
}
