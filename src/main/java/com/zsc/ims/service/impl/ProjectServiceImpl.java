package com.zsc.ims.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsc.ims.domain.entity.Project;
import com.zsc.ims.mapper.ProjectMapper;
import com.zsc.ims.service.ProjectService;
import com.zsc.ims.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper,Project>  implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;
    @Override
    public ResponseResult GetProjectList() {

        return null;
    }
}
