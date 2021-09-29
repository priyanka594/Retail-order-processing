package com.usecase.retail.controllers;

import com.usecase.retail.models.Order;
import com.usecase.retail.models.Product;
import com.usecase.retail.payload.OrderDetails;
import com.usecase.retail.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc

class OrdersControllerTest {

    @MockBean
    private OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "test", password = "test", roles = "USER")
    void testPrevOrderendpoint() throws Exception {
    List<Product> products = new ArrayList<>();
    Order order = new Order("1","processed","abc",products);
    ArrayList<Order> orders = new ArrayList<>();
    orders.add(order);
    doReturn(orders).when(orderService).fetchPrevOrderDetails("abc");
    mockMvc.perform( get("/prevorder").param("userid", "abc"))

           .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].id", is("1")))
            .andExpect(jsonPath("$[0].orderstatus", is("processed")))
            .andExpect(jsonPath("$[0].userid", is("abc")));
        }

    @Test
    @WithMockUser(username = "test", password = "test", roles = "USER")
    void testCreateOrder() throws Exception {
        List<Product> products = new ArrayList<>();
        OrderDetails order = new OrderDetails("abc",products);
        doNothing().when(orderService).saveOrderDetails(order);
    }


}
