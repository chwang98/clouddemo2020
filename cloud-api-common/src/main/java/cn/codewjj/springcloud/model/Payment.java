package cn.codewjj.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: cloud2020
 * @description: PaymentModel
 * @author: Mr.Wang
 * @create: 2020-10-24 21:11
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;

}


