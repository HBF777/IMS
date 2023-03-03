package com.zsc.ims.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsc.ims.domain.entity.Project;
import com.zsc.ims.mapper.ProjectMapper;
import com.zsc.ims.service.ProjectService;
import com.zsc.ims.utils.ResponseResult;

public class UserServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
    @Override
    public ResponseResult GetProjectList() {
        return null;
    }
}
