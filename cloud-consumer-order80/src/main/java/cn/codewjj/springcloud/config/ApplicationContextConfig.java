package cn.codewjj.springcloud.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: cloud2020
 * @description: Config
 * @author: Mr.Wang
 * @create: 2020-10-24 21:14
 **/

@Configuration
public class ApplicationContextConfig {

    @Bean
    //赋予RestTemplate负载均衡能力
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}


