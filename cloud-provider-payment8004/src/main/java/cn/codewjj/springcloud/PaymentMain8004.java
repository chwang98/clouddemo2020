package cn.codewjj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: cloud2020
 * @description: main class
 * @author: Mr.Wang
 * @create: 2020-10-25 20:28
 **/

@SpringBootApplication

//该注解用于向consul或者zookeeper作为注册中心是注册服务
@EnableDiscoveryClient
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}


