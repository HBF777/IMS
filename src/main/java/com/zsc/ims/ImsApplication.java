package com.zsc.ims;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zsc.ims.mapper")
public class ImsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImsApplication.class, args);
    }

}
