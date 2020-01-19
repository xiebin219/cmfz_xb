package com.baizhi.zcn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@tk.mybatis.spring.annotation.MapperScan("com.baizhi.zcn.dao")
@org.mybatis.spring.annotation.MapperScan("com.baizhi.zcn.dao")
@SpringBootApplication
public class CmfzZhangcnApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmfzZhangcnApplication.class, args);
    }

}
