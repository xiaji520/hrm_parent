package cn.xiaji.hrm;
//encoding: utf-8

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: xj
 * @contact: xiaruji520@gmail.com
 * @file: ConfigServer8848Application.java
 */
/*

 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServer8848Application {
    //主入口
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer8848Application.class, args);
    }
}