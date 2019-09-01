package cn.xiaji.hrm;
//encoding: utf-8


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: xj
 * @contact: xiaruji520@gmail.com
 * @file: SysManage9001Application.java
 */
/*

 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("cn.xiaji.hrm.mapper")
public class SysManage9001Application {
    //主入口
    public static void main(String[] args) {
        SpringApplication.run(SysManage9001Application.class, args);

    }
}