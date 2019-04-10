package com.dky.modules.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dky.common.utils.PageUtil;
import com.dky.common.utils.WrapperUtil;
import com.dky.modules.mq.enums.MidsuperviseEnum;
import com.dky.modules.sys.dao.MidsuperviseMapper;
import com.dky.modules.sys.model.Midsupervise;
import com.dky.modules.sys.service.MidsuperviseService;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * describe:保存或更新中期报告
 *
 * @author bowen
 * @date 2019/04/08
 */
@Service
public class MidsuperviseServiceImpl extends ServiceImpl<MidsuperviseMapper, Midsupervise> implements MidsuperviseService {
    /**
     * describe:保存或更新中期报告
     *
     * @author bowen
     * @date 2019/04/08
     */
    @Override
    public boolean saveOrUpdate(Midsupervise midsupervise) {
        if(midsupervise==null){
            return false;
        }
        return this.insertOrUpdate(midsupervise);
    }

    /**
     * describe:获取中期报告
     * 不传分页参数，将返回全部数据
     *
     * @author bowen
     * @date 2018/5/23
     */
    @Override
    public Page<Midsupervise> selectList(JSONObject json) {
        //设置分页参数
        Page<Midsupervise> page = new Page<>();
        PageUtil.StartPage(page, json);

        //设置查询条件
        Midsupervise midsupervise = JSONObject.parseObject(json.toString(), Midsupervise.class);
        EntityWrapper<Midsupervise> ew = new EntityWrapper<Midsupervise>();

        //教师ID
        WrapperUtil.eq(ew, json, MidsuperviseEnum.TEACHER_ID.getStringVal(), MidsuperviseEnum.TEACHER_ID.getStringVal());
        //学生ID
        WrapperUtil.eq(ew, json, MidsuperviseEnum.STUDENT_ID.getStringVal(), MidsuperviseEnum.STUDENT_ID.getStringVal());
        //进行查询并翻页
        List<Midsupervise> list = baseMapper.selectPage(page, ew);

        return page.setRecords(list);
    }

}
