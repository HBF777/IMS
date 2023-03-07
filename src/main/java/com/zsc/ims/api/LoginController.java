package com.zsc.ims.api;

import com.zsc.ims.domain.entity.User;
import com.zsc.ims.enums.AppHttpCodeEnum;
import com.zsc.ims.exception.SystemException;
import com.zsc.ims.service.LoginService;
import com.zsc.ims.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        if(!StringUtils.hasText(user.getUsername())){
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return loginService.login(user);
    }
    @GetMapping("/user/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
}
