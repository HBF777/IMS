package com.zsc.ims.service;

import com.zsc.ims.domain.entity.User;
import com.zsc.ims.utils.ResponseResult;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
