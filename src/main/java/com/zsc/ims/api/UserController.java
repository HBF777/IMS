package com.zsc.ims.api;

import com.zsc.ims.service.GroupService;
import com.zsc.ims.service.UserService;
import com.zsc.ims.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseResult registerGroupAdministrator(){
        // 创建组管理员用户
        Integer userId = userService.createGroupAdministrator();
        // 创建组
        Integer GroupId = groupService.createNewGroup(userId);
    }
}
