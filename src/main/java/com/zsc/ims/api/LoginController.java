package com.zsc.ims.api;

import com.zsc.ims.domain.entity.LoginUser;
import com.zsc.ims.domain.entity.User;
import com.zsc.ims.enums.AppHttpCodeEnum;
import com.zsc.ims.exception.SystemException;
import com.zsc.ims.service.LoginService;
import com.zsc.ims.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api(value = "登录Controller", tags = { "登录访问接口" })
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    @ApiOperation(value = "用户登录")
    @ApiResponses(value = {@ApiResponse(code = 1000, message="成功"),
            @ApiResponse(code=1001,message = "失败"),@ApiResponse(code=1002,response= LoginUser.class,message = "缺少参数")})
    public ResponseResult login(@RequestBody User user){
        if(!StringUtils.hasText(user.getUsername())){
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return loginService.login(user);
    }
    @ApiResponses(value = {@ApiResponse(code = 1000, message="成功"),
            @ApiResponse(code=1001,message = "失败"),@ApiResponse(code=1002,response= LoginUser.class,message = "缺少参数")})
    @GetMapping("/user/logout")
    @ApiOperation(value = "用户下线")
    public ResponseResult logout(){
        return loginService.logout();
    }
}
