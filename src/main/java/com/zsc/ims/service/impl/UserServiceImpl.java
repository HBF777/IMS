package com.zsc.ims.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsc.ims.domain.entity.Project;
import com.zsc.ims.domain.entity.User;
import com.zsc.ims.domain.entity.UserRole;
import com.zsc.ims.mapper.ProjectMapper;
import com.zsc.ims.mapper.UserMapper;
import com.zsc.ims.mapper.UserRoleMapper;
import com.zsc.ims.service.ProjectService;
import com.zsc.ims.service.UserRoleService;
import com.zsc.ims.service.UserService;
import com.zsc.ims.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public Integer createGroupAdministrator(User user){
        // 对密码进行加密处理
        user.setPasswd(passwordEncoder.encode(user.getPasswd()));
        System.out.println(user.getPasswd());
        save(user);
        if(user.getRoleIds()!=null&&user.getRoleIds().length>0){
            insertUserRole(user);
        }
        return null;
    }
    private void insertUserRole(User user) {
        List<UserRole> sysUserRoles = Arrays.stream(user.getRoleIds())
                .map(roleId -> new UserRole(user.getId(), roleId)).collect(Collectors.toList());
        userRoleService.saveBatch(sysUserRoles);
    }
    @Override
    public boolean checkUserNameUnique(String username) {
        return count(Wrappers.<User>lambdaQuery().eq(User::getUsername,username))==0;
    }

    @Override
    public boolean checkPhoneUnique(User user) {
        return count(Wrappers.<User>lambdaQuery().eq(User::getPhone,user.getPhone()))==0;
    }

    @Override
    public boolean checkEmailUnique(User user) {
        return count(Wrappers.<User>lambdaQuery().eq(User::getEmail,user.getEmail()))==0;
    }
}
