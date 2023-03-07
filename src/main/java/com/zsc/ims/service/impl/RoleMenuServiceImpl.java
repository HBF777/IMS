package com.zsc.ims.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsc.ims.domain.entity.RoleMenu;
import com.zsc.ims.mapper.RoleMenuMapper;
import com.zsc.ims.service.RoleMenuService;
import org.springframework.stereotype.Service;


@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {
    @Override
    public void deleteRoleMenuByRoleId(Integer id) {

    }

}
