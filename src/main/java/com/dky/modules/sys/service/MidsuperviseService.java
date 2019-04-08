package com.dky.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.dky.modules.sys.model.Midsupervise;


/**
 * describe:
 *
 * @author bowen
 * @date 2019/04/08
 */
public interface MidsuperviseService extends IService<Midsupervise> {
    boolean saveOrUpdate(Midsupervise midsupervise);

    /**
     * describe:保存或更新中期报告
     *
     * @author bowen
     * @date 2018/5/23
     */
}
