package com.usecase.retail.repository;

import com.usecase.retail.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;


public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findAllByUserid(String userid);
    boolean existsByUserid(String userid);
}
