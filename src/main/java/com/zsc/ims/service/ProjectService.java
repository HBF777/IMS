package com.zsc.ims.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsc.ims.domain.entity.Project;
import com.zsc.ims.domain.entity.User;
import com.zsc.ims.utils.ResponseResult;

public interface ProjectService extends IService<Project> {
    ResponseResult GetProjectList(Integer GroupId,Integer pageNum, Integer pageSize);

    ResponseResult getProjectInfo(Integer userId);

    Integer createGroupAdministrator(User user);
}
