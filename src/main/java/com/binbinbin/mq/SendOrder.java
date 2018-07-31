package com.binbinbin.mq;

import com.binbinbin.entity.OrderEntity;

/**
 * Created by bin on 2018/7/30.
 */
public interface SendOrder {
    boolean send1(OrderEntity order);

    boolean send2(OrderEntity order);

    //boolean send2(OrderEntity order);
}
