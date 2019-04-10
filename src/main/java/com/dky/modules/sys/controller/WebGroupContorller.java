package com.dky.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.dky.common.annotation.Mylog;
import com.dky.common.model.R;
import com.dky.common.utils.JwtTokenUtil;
import com.dky.modules.sys.service.GroupService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * describe:
 *
 * @author bowen
 * @date 2019/04/06
 */
@RestController
@RequestMapping(Constant.group)
public class WebGroupContorller {
    @Resource
    GroupService groupService;
    @Mylog("获取答辩组成员信息")
    @GetMapping("/list")
    @ApiOperation("获取答辩组成员信息")
    public R list(@RequestBody JSONObject json) {
        return R.ok(groupService.selectList(json));
    }
}
