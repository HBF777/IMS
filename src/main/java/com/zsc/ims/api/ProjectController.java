package com.zsc.ims.api;

import com.zsc.ims.service.ProjectService;
import com.zsc.ims.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @GetMapping("/{id}")
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
