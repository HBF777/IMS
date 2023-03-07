package com.zsc.ims.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsc.ims.domain.entity.User;

/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2023-03-03 14:33:30
 */
public interface UserService extends IService<User> {

    public Integer createGroupAdministrator(User user);

    boolean checkUserNameUnique(String username);

    boolean checkPhoneUnique(User user);

    boolean checkEmailUnique(User user);
}

