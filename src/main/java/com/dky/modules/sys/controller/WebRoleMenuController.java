package com.dky.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dky.common.model.R;
import com.dky.modules.sys.model.RoleMenu;
import com.dky.modules.sys.service.RoleMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * describe: 角色菜单
 *
 * @author bowen
 * @date 2018/5/23
 */
@RestController
@RequestMapping(value = Constant.rolemenu)
public class WebRoleMenuController {

    @Resource
    private RoleMenuService roleMenuService;

    /**
     * describe: 根据roleId获取角色菜单关系
     *
     * @author bowen
     * @date 2018/5/23
     */
    @ApiOperation("根据roleId获取角色菜单关系")
    @GetMapping(value = "/{roleId}")
    public R roleMenu(@PathVariable String roleId) {
        return R.ok(roleMenuService.selectList(new EntityWrapper<RoleMenu>().eq("role_id", roleId)));
    }

//    /**
//     * describe:添加角色菜单--一个角色添加多个菜单
//     *
//     * @author bowen
//     * @date 2018/5/23
//     */
//    @PostMapping(value = {""})
//    @ApiOperation("添加角色菜单  {roleId:1,menuIds:[1,2,3]}")
//    public R saveRoleMenu(@RequestBody JSONObject json) {
//        //json {roleId:1,menuIds:[1,2,3]}
//        return R.ok(roleMenuService.saveRoleMenu(json));
//    }


    /**
     * describe: 添加权限菜单与权限按钮的关联关系
     *
     * @author bowen
     * @date 2018/5/25
     *//*
    @PostMapping(value = "addRoleAndButton")
    @ApiOperation("添加权限菜单与权限按钮的关联关系")
    public R saveRoleMenuAndRoleButton(@RequestBody JSONObject json) {
//        {
//            "menu":{ "roleId":"1","menuIds":[1,2,3,4]},
//            "button":{"roleId":"1","buttonIds":[1,2,3,4]}
//        }
        return R.ok(roleMenuService.saveRoleMenuAndRoleButton(json));
    }*/

}

