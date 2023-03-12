package com.zsc.ims.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsc.ims.domain.entity.Group;
import com.zsc.ims.mapper.GroupMapper;
import com.zsc.ims.service.GroupService;
import com.zsc.ims.utils.InviteCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {

    @Autowired
    private  GroupMapper groupMapper;
    @Override
    public void createNewGroup(Integer userId) throws NoSuchAlgorithmException {
        // 创建团队
        Group group = new Group();
        group.setManager(userId);
        group.setCreatedDate(new Date());
        group.setInvite_code(InviteCodeGenerator.generateCode());
        groupMapper.insert(group);
    }
}
