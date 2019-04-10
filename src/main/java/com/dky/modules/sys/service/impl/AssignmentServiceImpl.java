package com.dky.modules.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dky.common.utils.PageUtil;
import com.dky.common.utils.WrapperUtil;
import com.dky.modules.mq.enums.AssignmentEnum;
import com.dky.modules.mq.enums.RoleEnum;
import com.dky.modules.sys.dao.AssignmentMapper;
import com.dky.modules.sys.model.Assignment;
import com.dky.modules.sys.model.Project;
import com.dky.modules.sys.model.Role;
import com.dky.modules.sys.service.AssignmentService;
import com.dky.modules.sys.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * describe:
 *
 * @author bowen
 * @date 2019/04/09
 */
@Service

public class AssignmentServiceImpl extends ServiceImpl<AssignmentMapper, Assignment> implements AssignmentService {
    @Resource
    ProjectService projectService;

    @Override
    public Page<Assignment> selectById(JSONObject json) {
        Integer stuId=JSONObject.parseObject(json.toString(), Assignment.class).getStudentId();
        Integer teaId=JSONObject.parseObject(json.toString(),Assignment.class).getTeacherId();
        //查询课题表中是否存在学生ID(学生是否选题),若json不传参则会查询全部课题，所以判断stuId、teaId
        if(stuId==null||teaId==null||projectService.selectList(json)==null)
            return null;
        //设置分页参数
        Page<Assignment> page = new Page<>();
        PageUtil.StartPage(page, json);

        //设置查询条件
        EntityWrapper<Assignment> ew = new EntityWrapper<Assignment>();

        //学生ID
        WrapperUtil.eq(ew, json, AssignmentEnum.STUDENT_ID.getStringVal(), AssignmentEnum.STUDENT_ID.getStringVal());
        //教师ID
        WrapperUtil.eq(ew, json, AssignmentEnum.TEACHER_ID.getStringVal(), AssignmentEnum.TEACHER_ID.getStringVal());
        List<Assignment> list = baseMapper.selectPage(page, ew);
        //进行查询并翻页
        return page.setRecords(list);
    }
}
