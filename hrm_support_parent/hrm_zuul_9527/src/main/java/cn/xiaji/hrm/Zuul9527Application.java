package cn.xiaji.hrm;
//encoding: utf-8

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: xj
 * @contact: xiaruji520@gmail.com
 * @file: Zuul9527Application.java
 */
/*

 */
@SpringBootApplication
@EnableEurekaClient
//开启网关支持
@EnableZuulProxy
public class Zuul9527Application {
    //主入口
    public static void main(String[] args) {
        SpringApplication.run(Zuul9527Application.class, args);
    }
}