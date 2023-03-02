package com.zsc.ims.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsc.ims.domain.entity.Project;
import com.zsc.ims.utils.ResponseResult;

public interface ProjectService extends IService<Project> {
    ResponseResult GetProjectList();
}
