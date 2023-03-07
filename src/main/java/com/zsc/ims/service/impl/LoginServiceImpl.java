package com.zsc.ims.service.impl;

import com.zsc.ims.constants.RedisCacheConstants;
import com.zsc.ims.domain.entity.LoginUser;
import com.zsc.ims.domain.entity.User;
import com.zsc.ims.enums.AppHttpCodeEnum;
import com.zsc.ims.service.LoginService;
import com.zsc.ims.utils.JwtUtil;
import com.zsc.ims.utils.RedisCache;
import com.zsc.ims.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;


    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPasswd());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        // 使用userId生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        redisCache.setCacheObject(RedisCacheConstants.LOGIN +userId,loginUser);
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return new ResponseResult().okResult(jwt);
    }

    @Override
    public ResponseResult logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Integer userId = loginUser.getUser().getId();
        redisCache.deleteObject(RedisCacheConstants.LOGIN+userId);
        return new ResponseResult(200,"退出成功");
    }
}
