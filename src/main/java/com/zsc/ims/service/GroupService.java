package com.zsc.ims.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsc.ims.domain.entity.Group;

import java.security.NoSuchAlgorithmException;

/**
 * (Group)表服务接口
 *
 * @author makejava
 * @since 2023-03-03 15:20:20
 */
public interface GroupService extends IService<Group> {

    public void createNewGroup(Integer userId) throws NoSuchAlgorithmException;
}

