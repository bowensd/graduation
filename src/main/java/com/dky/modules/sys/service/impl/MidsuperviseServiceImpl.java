package com.dky.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dky.common.model.R;
import com.dky.modules.sys.dao.MidsuperviseMapper;
import com.dky.modules.sys.model.Midsupervise;
import com.dky.modules.sys.service.MidsuperviseService;
import org.springframework.stereotype.Service;

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
        return this.saveOrUpdate(midsupervise);
    }
}
