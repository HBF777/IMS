package com.zsc.ims.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsc.ims.domain.entity.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    List<String> selectRoleKeyByUserId(Integer userId);
    List<Integer> selectRoleByUserId(Integer userID);
}
