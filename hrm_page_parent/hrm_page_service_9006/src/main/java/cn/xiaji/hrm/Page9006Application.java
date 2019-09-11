package cn.xiaji.hrm;
//encoding: utf-8

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: xj
 * @contact: xiaruji520@gmail.com
 * @file: Page9006Application.java
 */
/*

 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("cn.xiaji.hrm.mapper")
@EnableFeignClients
public class Page9006Application {
    //主入口
    public static void main(String[] args) {
        SpringApplication.run(Page9006Application.class, args);
    }
}