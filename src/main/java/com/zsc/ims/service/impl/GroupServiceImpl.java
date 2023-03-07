package com.zsc.ims.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsc.ims.domain.entity.Group;
import com.zsc.ims.mapper.GroupMapper;
import com.zsc.ims.service.GroupService;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {
    @Override
    public Integer createNewGroup(Integer userId) {
        return null;
    }
}
