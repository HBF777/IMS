package com.zsc.ims.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsc.ims.domain.entity.RoleMenu;

public interface RoleMenuService extends IService<RoleMenu> {
    void deleteRoleMenuByRoleId(Integer id);
}
