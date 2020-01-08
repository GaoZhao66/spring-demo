package com.cmb.updatefile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cmb.file.updatefile.mapper")
@SpringBootApplication
public class UpdateFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpdateFileApplication.class, args);
    }

}
