package com.dky.modules.sys.controller;

import com.dky.common.annotation.Mylog;
import com.dky.common.model.R;
import com.dky.modules.sys.model.Midsupervise;
import com.dky.modules.sys.service.MidsuperviseService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * describe:
 *
 * @author bowen
 * @date 2019/04/08
 */
@RestController
@RequestMapping(value = Constant.midsupervise)
public class WebMidsuperviseController  {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private MidsuperviseService midsuperviseService;

    /**
     *describe:保存或更新中期报告
     *
     *@author bowen
     *@date 2018/5/24
     */
    @Mylog("保存或更新中期报告")
    @PostMapping(value={""})
    @ApiOperation("保存或更新中期报告")
    public R saveOrUpdage(@RequestBody Midsupervise midsupervise){
        return R.ok(midsuperviseService.saveOrUpdate(midsupervise));
    }


}
