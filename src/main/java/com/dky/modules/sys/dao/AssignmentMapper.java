package com.dky.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dky.modules.sys.model.Assignment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AssignmentMapper extends BaseMapper<Assignment> {
    @Select("SELECT\n" +
            "assignment.*\n" +
            "FROM a_base_assignment assignment\n" +
            "INNER JOIN a_base_project project on assignment.student_id=project.student_id\n")
    List<Assignment> assigListByStuId();
}
