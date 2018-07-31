package com.binbinbin.controller;

import com.binbinbin.entity.OrderEntity;
import com.binbinbin.mq.SendOrder;
import com.binbinbin.service.OrderService;
import com.binbinbin.util.SnowflakeIdWorker;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by bin on 2018/5/15.
 */
@RestController
@RequestMapping("/order/")
public class OrderController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private SnowflakeIdWorker idWorker;
    @Autowired
    private OrderService orderService;
    @Autowired
    private SendOrder sendOrder;
    /**
     *
     * @return
     */
    @RequestMapping("order")
    public String order(OrderEntity order){
        return orderService.save(order);
    }
    /**
     *
     * @return
     */
    @RequestMapping("order1")
    public boolean order1(OrderEntity order){
        return sendOrder.send1(order);
    }
    @RequestMapping("order2")
    public boolean order2(OrderEntity order){
        return sendOrder.send2(order);
    }
}
