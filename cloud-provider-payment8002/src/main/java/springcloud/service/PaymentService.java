package springcloud.service;

import cn.codewjj.springcloud.model.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cloud2020
 * @description: PaymentSerice接口
 * @author: Mr.Wang
 * @create: 2020-10-24 15:45
 **/


public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}


