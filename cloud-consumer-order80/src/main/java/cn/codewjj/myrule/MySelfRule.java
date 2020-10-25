package cn.codewjj.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cloud2020
 * @description: RestTemplat的负载均衡策略rule
 * @author: Mr.Wang
 * @create: 2020-10-25 22:33
 **/


@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        //定义为随机规则
        return new RandomRule();
    }
}


