package com.usecase.retail.controllers;


import com.usecase.retail.models.Order;
import com.usecase.retail.payload.OrderDetails;
import com.usecase.retail.payload.response.MessageResponse;
import com.usecase.retail.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class OrdersController {

    @Autowired
    OrderService orderService;


    @PostMapping("/createorder")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderDetails orderDetails) {
        orderService.saveOrderDetails(orderDetails);
        return ResponseEntity.ok(new MessageResponse("Order created successfully!"));
    }



    @GetMapping("/prevorder")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Order> fetchPrevOrder(@RequestParam(value = "userid", required = true) String userid)  {
      return orderService.fetchPrevOrderDetails(userid);
    }

}
