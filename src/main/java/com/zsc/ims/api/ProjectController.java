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
    public ResponseResult ProjectList(@PathVariable Integer id){
        ResponseResult result = projectService.GetProjectList();
        return null;
    }
}
