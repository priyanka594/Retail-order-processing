package com.usecase.retail.service.Impl;

import com.usecase.retail.models.Order;
import com.usecase.retail.models.Product;
import com.usecase.retail.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    OrderServiceImpl orderService;

    @MockBean
    OrderRepository orderRepository ;

    @MockBean
    KafkaTemplate<String, Order> KafkaJsontemplate;

    @Test
    void findAllByUserid() {

        List<Product> products = new ArrayList<>();
        Order order = new Order("1","processed","abc",products);
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order);
        doReturn(orders).when(orderRepository).findAllByUserid("abc");
    }

    @Test
    void testsaveOrderDetails()
    {
        List<Product> products = new ArrayList<>();
        Order order = new Order("1","processed","abc",products);
        orderRepository.save(order);
        KafkaJsontemplate.send("abc", order);
    }


    @Test
    void testFindIfIdExists()
    {
      boolean userdId =  orderRepository.existsById("abc");
        Assertions.assertFalse(userdId, "userid not be found");
    }

}




