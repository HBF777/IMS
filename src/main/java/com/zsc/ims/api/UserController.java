package com.zsc.ims.api;

import com.zsc.ims.domain.entity.User;
import com.zsc.ims.enums.AppHttpCodeEnum;
import com.zsc.ims.service.GroupService;
import com.zsc.ims.service.UserService;
import com.zsc.ims.utils.ResponseResult;
import com.zsc.ims.exception.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/register/groupAdmin/{activeCode}")
    public ResponseResult registerGroupAdministrator(@PathVariable("activeCode") Integer activeCode, @RequestBody User user){
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
        // 创建组管理员用户
        Integer userId = userService.createGroupAdministrator(user);
        // 创建组
        Integer GroupId = groupService.createNewGroup(userId);
        return ResponseResult.okResult();
    }
}
