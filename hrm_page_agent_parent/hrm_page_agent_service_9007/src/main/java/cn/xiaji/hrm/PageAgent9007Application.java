package cn.xiaji.hrm;
//encoding: utf-8

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: xj
 * @contact: xiaruji520@gmail.com
 * @file: PageAgent9007Application.java
 */
/*

 */
@SpringBootApplication
@EnableEurekaClient
public class PageAgent9007Application {
    //主入口
    public static void main(String[] args) {
        SpringApplication.run(PageAgent9007Application.class, args);
    }
}