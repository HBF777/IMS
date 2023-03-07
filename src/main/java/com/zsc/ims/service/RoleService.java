package com.zsc.ims.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsc.ims.domain.entity.Role;
import com.zsc.ims.utils.ResponseResult;

import java.util.List;

public interface RoleService extends IService<Role> {

    List<String> selectRoleKeyByUserId(Integer id);

    ResponseResult selectRolePage(Role role, Integer pageNum, Integer pageSize);

    void insertRole(Role role);

    void updateRole(Role role);

    List<Role> selectRoleAll();

    List<Integer> selectRoleIdByUserId(Integer userId);
}
