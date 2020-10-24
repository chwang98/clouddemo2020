package cn.codewjj.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: cloud2020
 * @description: 公共返回类
 * @author: Mr.Wang
 * @create: 2020-10-24 15:27
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CommonResult<T> {
    //404 page no found

    //200 success

    private Integer code;
    private String message;
    private T Data;

    public CommonResult (Integer code ,String message){
        this(code,message,null);
    }
}


