package cn.xiaji.hrm;
//encoding: utf-8

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: xj
 * @contact: xiaruji520@gmail.com
 * @file: EurekaServer7001Application.java
 */
/*

 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001Application {
    //主入口
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001Application.class, args);
    }
}