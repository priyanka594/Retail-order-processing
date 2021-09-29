package com.usecase.retail.kafka;

import com.usecase.retail.models.Order;
import com.usecase.retail.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @Autowired
    OrderRepository orderRepository;

    private final Logger logger
            = LoggerFactory.getLogger(Consumer.class);
    @KafkaListener(
            topics = "order",
            groupId = "order-consumer",
            containerFactory
            = "userKafkaListenerContainerFactory"
    )
    public void listen( Order order){
        order.setOrderstatus("processed");
        orderRepository.save(order);
        logger.info(String.format("User created -> %s", order.getId()));
    }
}
