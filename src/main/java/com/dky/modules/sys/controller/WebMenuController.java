package com.dky.modules.sys.controller;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dky.common.model.R;
import com.dky.common.utils.JwtTokenUtil;
import com.dky.modules.sys.model.Menu;
import com.dky.modules.sys.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
*describe:菜单
*
*@author bowen
*@date 2018/5/11 8:39
*/
@RestController
@RequestMapping(value = Constant.menu)
public class WebMenuController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private MenuService menuService;

    /**
     *describe: 获取用户的菜单列表
     *@author bowen
     *@date 2018/5/23
     */
    @GetMapping("/menuListByUser")
    @ApiOperation("获取用户的菜单列表")
    public R menuListByUser (HttpServletRequest request){
        String userName = JwtTokenUtil.getUsername(request);
        return R.ok(menuService.menuListByUserName(userName));
    }


}
