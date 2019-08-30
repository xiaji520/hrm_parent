package cn.xiaji.hrm;
//encoding: utf-8

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: xj
 * @contact: xiaruji520@gmail.com
 * @file: GateWay9527Application.java
 */
/*

 */
@SpringBootApplication
//开启网关支持
@EnableZuulProxy
public class GateWay9527Application {
    //主入口
    public static void main(String[] args) {
        SpringApplication.run(GateWay9527Application.class, args);
    }
}