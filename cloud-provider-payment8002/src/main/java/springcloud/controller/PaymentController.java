package springcloud.controller;

import cn.codewjj.springcloud.model.CommonResult;
import cn.codewjj.springcloud.model.Payment;
import cn.codewjj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: cloud2020
 * @description: payment控制器
 * @author: Mr.Wang
 * @create: 2020-10-24 15:52
 **/

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int resule = paymentService.create(payment);
        log.info("插入结果====="+resule);
        if (resule>0)
        {
            return new CommonResult(200,"插入成功",resule);
        }else {
            return new CommonResult(444,"插入失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("插入结果====="+payment);
        if (payment != null)
        {
            return new CommonResult(200,"查询成功",payment);
        }else {
            return new CommonResult(444,"查询失败"+id,null);
        }
    }

}


