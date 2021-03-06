package cn.codewjj.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: cloud2020
 * @description: controller
 * @author: Mr.Wang
 * @create: 2020-10-25 21:29
 **/

@RestController
@Slf4j
public class OrderController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo(){
        String forObject = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);

        return forObject;

    }
}


