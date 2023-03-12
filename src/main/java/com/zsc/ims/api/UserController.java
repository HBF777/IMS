package com.zsc.ims.api;

import com.zsc.ims.domain.entity.LoginUser;
import com.zsc.ims.domain.entity.User;
import com.zsc.ims.enums.AppHttpCodeEnum;
import com.zsc.ims.service.GroupService;
import com.zsc.ims.service.UserService;
import com.zsc.ims.utils.ResponseResult;
import com.zsc.ims.exception.SystemException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController()
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    /**
     * 注册组管理员用户，创建组管理员用户的时候应当同时创建组
     */
    @Transactional
    @ApiResponses(value = {@ApiResponse(code = 200, message="成功"),
            @ApiResponse(code=500,message = "失败"),@ApiResponse(code=304,response= User.class,message = "缺少参数")})
    @PostMapping("/register/groupAdmin")
    @ApiOperation(value = "注册团队管理员账户")
    public ResponseResult registerGroupAdministrator( @RequestBody User user) throws NoSuchAlgorithmException {
        checkUser(user);
        // 创建组管理员用户
        Integer userId = userService.createGroupAdministrator(user);
        // 创建组
        groupService.createNewGroup(userId);
        return ResponseResult.okResult();
    }

    private void checkUser(User user) {
        if(!StringUtils.hasText(user.getUsername())){
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        if (!userService.checkUserNameUnique(user.getUsername())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        if (!userService.checkPhoneUnique(user)){
            throw new SystemException(AppHttpCodeEnum.PHONENUMBER_EXIST);
        }
        if (!userService.checkEmailUnique(user)){
            throw new SystemException(AppHttpCodeEnum.EMAIL_EXIST);
        }
    }

    @PostMapping("/register/groupMember/{activeCode}")
    @ApiOperation(value = "注册团队成员账户")
    @ApiResponses(value = {@ApiResponse(code=200, message = "成功")})
    public ResponseResult registerGroupMember(@PathVariable("activeCode") String activeCode,@RequestBody User user){
        checkUser(user);
        Integer userId = userService.createGroupMember(user,activeCode);
        return null;
    }

    @DeleteMapping("/delete/groupMember")
    @ApiOperation(value = "删除团队成员用户")
    public ResponseResult deleteGroupMember(@RequestBody User user){

        return null;
    }
}
