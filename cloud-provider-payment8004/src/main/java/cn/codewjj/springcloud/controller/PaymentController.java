package cn.codewjj.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.UUID;

/**
 * @program: cloud2020
 * @description: controller
 * @author: Mr.Wang
 * @create: 2020-10-25 20:30
 **/

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper:\t"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}


