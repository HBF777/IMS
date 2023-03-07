package com.zsc.ims.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.istack.internal.Pool;
import com.zsc.ims.domain.entity.UserRole;
import com.zsc.ims.mapper.UserRoleMapper;
import com.zsc.ims.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}
