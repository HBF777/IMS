package com.zsc.ims.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsc.ims.constants.SystemConstants;
import com.zsc.ims.domain.entity.Project;
import com.zsc.ims.domain.entity.User;
import com.zsc.ims.domain.vo.PageVo;
import com.zsc.ims.domain.vo.ProjectVo;
import com.zsc.ims.mapper.ProjectMapper;
import com.zsc.ims.service.ProjectService;
import com.zsc.ims.utils.BeanCopyUtils;
import com.zsc.ims.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper,Project>  implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;
    @Override
    public ResponseResult GetProjectList(Integer GroupId,Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Project> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Project::getGroupId,GroupId);
        queryWrapper.eq(Project::getStatus, SystemConstants.PROJECT_STATUS_NORMAL);
        queryWrapper.orderByDesc(Project::getStart_time);
        Page<Project> page = new Page(pageNum,pageSize);
        page(page,queryWrapper);
        List<ProjectVo> projectVos = BeanCopyUtils.copyBeanList(page.getRecords(),ProjectVo.class);
        PageVo pageVo = new PageVo(projectVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult getProjectInfo(Integer userId) {
        return null;
    }

    @Override
    public Integer createGroupAdministrator(User user) {
        return null;
    }
}
