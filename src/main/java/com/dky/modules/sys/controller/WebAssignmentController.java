package com.dky.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.dky.common.annotation.Mylog;
import com.dky.common.model.R;
import com.dky.modules.sys.model.Assignment;
import com.dky.modules.sys.service.AssignmentService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * describe:
 *
 * @author bowen
 * @date 2019/04/09
 */
@RestController
@RequestMapping(Constant.assignment)
public class WebAssignmentController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * describe: 用户登陆入口映射
     *
     * @author bowen
     * @date 2018/5/14 20:08
     */
    @Resource
    AssignmentService assignmentService;


    @Mylog("根据ID获取任务书")
    @PostMapping(value = "list")
    @ApiOperation("获取任务书列表,json中加入学生ID/教师ID可以根据ID查询")
    public R selectById(@RequestBody JSONObject json) {
        if (assignmentService.selectById(json)==null)
            return R.error();
        return R.ok(assignmentService.selectById(json));
    }

    @Mylog("保存或更新任务书")
    @PostMapping(value = {""})
    @ApiOperation("保存或更新任务书")
    public R saveOrUpdage(@RequestBody Assignment assignment) {
        return R.ok(assignmentService.saveOrUpdate(assignment));
    }

}
