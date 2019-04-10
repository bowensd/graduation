package com.dky.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dky.modules.sys.model.Group;
import com.dky.modules.sys.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * describe:
 *
 * @author bowen
 * @date 2019/03/28
 */
@Mapper
public interface GroupMapper extends BaseMapper<Group> {
    @Select("SELECT " +
            " * " +
            "FROM " +
            " a_base_group g " +
            "GROUP BY g.num" )
    List<User> getGroupUser();
}
