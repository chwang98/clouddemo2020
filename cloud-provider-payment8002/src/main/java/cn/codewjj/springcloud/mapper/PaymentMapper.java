package cn.codewjj.springcloud.mapper;

import cn.codewjj.springcloud.model.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cloud2020
 * @description: 接口
 * @author: Mr.Wang
 * @create: 2020-10-24 15:31
 **/
@Mapper
public interface PaymentMapper {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
