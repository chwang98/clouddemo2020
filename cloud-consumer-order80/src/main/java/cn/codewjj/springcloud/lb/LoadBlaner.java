package cn.codewjj.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @program: cloud2020
 * @description: LoabBalanced
 * @author: Mr.Wang
 * @create: 2020-10-26 14:12
 **/
public interface LoadBlaner {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);


}
