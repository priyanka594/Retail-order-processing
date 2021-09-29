package com.usecase.retail.service;

import com.usecase.retail.models.Order;
import com.usecase.retail.payload.OrderDetails;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface OrderService {

    void saveOrderDetails(OrderDetails orderDetails);
    List<Order> fetchPrevOrderDetails(String userid);
}
