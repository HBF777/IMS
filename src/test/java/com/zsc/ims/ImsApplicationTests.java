package com.zsc.ims;

import com.zsc.ims.domain.entity.Project;
import com.zsc.ims.mapper.ProjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ImsApplicationTests {

    @Autowired
    private ProjectMapper projectMapper;
    @Test
    void contextLoads() {
        projectMapper.selectList(null)

    }

}
