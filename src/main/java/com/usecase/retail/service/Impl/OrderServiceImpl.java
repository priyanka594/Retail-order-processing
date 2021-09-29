package com.usecase.retail.service.Impl;

import com.usecase.retail.Exception.UserNotFoundException;
import com.usecase.retail.models.Order;
import com.usecase.retail.payload.OrderDetails;
import com.usecase.retail.repository.OrderRepository;
import com.usecase.retail.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository ;

    @Autowired
    KafkaTemplate<String, Order> KafkaJsontemplate;
    String TOPIC_NAME = "order";

    @Override
    public void saveOrderDetails(OrderDetails orderDetails) {

        Order order = new Order();
        order.setOrderstatus("placed");
        order.setUserid(orderDetails.getUserid());
        order.setProducts(orderDetails.getProducts());
        orderRepository.save(order);
        KafkaJsontemplate.send(TOPIC_NAME,order);
    }

    @Override
    public List<Order> fetchPrevOrderDetails(String userid) {
        if(!orderRepository.existsByUserid(userid)) throw  new UserNotFoundException();

        return  orderRepository.findAllByUserid(userid);
    }
}
