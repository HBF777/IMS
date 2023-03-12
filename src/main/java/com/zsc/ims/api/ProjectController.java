package com.zsc.ims.api;

import com.zsc.ims.service.ProjectService;
import com.zsc.ims.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
@Api(value = "项目Controller", tags = {"项目管理接口"})
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @GetMapping("/{id}")
    @ApiOperation(value = "获取当前团队所有项目")
    public ResponseResult ProjectList(Integer pageNum, Integer pageSize,@PathVariable("id") Integer Groupid){
        ResponseResult result = projectService.GetProjectList(Groupid,pageNum,pageSize);
        return result;
    }
    @GetMapping("/info/{id}")
    public ResponseResult GetProjectInfo(Integer userId){
        projectService.getProjectInfo(userId);
        return null;
    }
}
