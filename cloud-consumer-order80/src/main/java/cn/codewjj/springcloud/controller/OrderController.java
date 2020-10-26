package cn.codewjj.springcloud.controller;

import cn.codewjj.springcloud.lb.LoadBlaner;
import cn.codewjj.springcloud.model.CommonResult;
import cn.codewjj.springcloud.model.Payment;
import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @program: cloud2020
 * @description: OrderController
 * @author: Mr.Wang
 * @create: 2020-10-24 21:10
 **/

@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT = "CLOUD-PAYMENT-SERVICE";
    public static final String PAYMENT_URL = "http://"+PAYMENT;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBlaner loadBlaner;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id ){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }


    @GetMapping(value = "/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentForEntity(@PathVariable("id") Long id ){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            log.info(forEntity.getStatusCode().toString());
            return forEntity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }
//        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);

    }
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){

        List<ServiceInstance> instances = discoveryClient.getInstances(PAYMENT);
        if (CollUtil.isEmpty(instances))
        {
            return null;
        }

        ServiceInstance instance = loadBlaner.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);


    }
}