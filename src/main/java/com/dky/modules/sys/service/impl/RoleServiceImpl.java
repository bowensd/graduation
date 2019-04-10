package com.dky.modules.sys.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dky.common.utils.PageUtil;
import com.dky.common.utils.WrapperUtil;
import com.dky.modules.mq.enums.RoleEnum;
import com.dky.modules.sys.dao.RoleMapper;
import com.dky.modules.sys.model.Role;
import com.dky.modules.sys.service.RoleService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * describe: 角色
 *
 * @author bowen
 * @date 2018/5/23 17:00
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    /**
     * describe:删除角色（伪删除）
     *
     * @author bowen
     * @date 2018/5/23
     */
    @Override
    public Map delete(JSONArray ids) {
        int successNum = 0;
        int errNum = 0;
        String msg = "error";
        for (int i = 0; i < ids.size(); i++) {
            String id = ids.getString(i);
            List<Role> list = this.selectList(new EntityWrapper().eq(RoleEnum.P_ID.getStringVal(), id));
            if (list != null && list.size() > 0) {
                errNum++;
                continue;
            }
            Role role = new Role();
            role.setId(id);
            role.setDeletedCode(RoleEnum.DELETED.getIntegerVal());
            role.setDeletedName(RoleEnum.DELETED.getName());
            boolean flag = this.updateById(role);

            if (flag) {
                successNum++;
                msg = "success";
            } else {
                errNum++;
            }
        }
        Map map = new HashMap<String, String>(3);
        map.put("succNum", successNum);
        map.put("errNum", errNum);
        map.put("msg", msg);

        return map;
    }

    /**
     * describe:保存或更改角色
     *
     * @author bowen
     * @date 2018/5/23
     */
    @Override
    public boolean saveOrUpdate(Role role) {
        return this.insertOrUpdate(role);
    }

    /**
     * describe:获取角色列表
     * 不传分页参数，将返回全部数据
     *
     * @author bowen
     * @date 2018/5/23
     */
    @Override
    public Page<Role> selectList(JSONObject json) {
        //设置分页参数
        Page<Role> page = new Page<>();
        PageUtil.StartPage(page, json);

        //设置查询条件
        Role role = JSONObject.parseObject(json.toString(), Role.class);
        EntityWrapper<Role> ew = new EntityWrapper<Role>();

        //名称
        if (role != null && role.getName() != null && !"".equals(role.getName())) {
            ew.like(RoleEnum.NAME.getStringVal(), role.getName());
        }
        //类型
        WrapperUtil.eq(ew, json, RoleEnum.TYPE.getStringVal(), RoleEnum.TYPE.getStringVal());

        //父ID
        WrapperUtil.eq(ew, json, RoleEnum.P_ID.getStringVal(), RoleEnum.P_ID.getStringVal());

        //是否启用
        WrapperUtil.eq(ew, json,RoleEnum.STATE_CODE.getStringVal(), RoleEnum.STATE_CODE.getStringVal());

        //同步状态
        WrapperUtil.eq(ew, json, RoleEnum.SYNC_CODE.getStringVal(), RoleEnum.SYNC_CODE.getStringVal());

        //未删除
        ew.eq(RoleEnum.DELETED_CODE.getStringVal(), RoleEnum.UNDELETED.getStringVal());
        ew.orderBy(RoleEnum.SORT_INDEX.getStringVal());

        //进行查询并翻页
        List<Role> list = baseMapper.selectPage(page, ew);

        //查询不到返回本身
//        if (list == null || list.size() == 0) {
//            try {
//                list.add(baseMapper.selectById(role.getUserId()));
//            } catch (Exception e) {
//                return page.setRecords(null);
//            }
//        }

        return page.setRecords(list);
    }

    /**
     * describe: 获取角色列表，并附带角色下人数
     *
     * @author bowen
     * @date 2018/5/24
     */
    @Override
    public Page<Map<String, Object>> listNew(JSONObject json) {
        Page<Map<String, Object>> page = new Page<>();
        PageUtil.StartPage(page, json);
        Role role = JSONObject.parseObject(json.toString(), Role.class);
        List<Map<String, Object>> list = this.baseMapper.listNew(page, role, RoleEnum.UNDELETED.getIntegerVal());
        return page.setRecords(list);
    }

}