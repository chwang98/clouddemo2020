package cn.codewjj.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: cloud2020
 * @description: myLB
 * @author: Mr.Wang
 * @create: 2020-10-26 14:15
 **/

@Component
public class MyLB implements LoadBlaner {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current +1;
        }while (! this.atomicInteger.compareAndSet(current,next));
        System.out.println("第"+next+"次访问");
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int i = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(i);
    }
}


