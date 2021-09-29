package com.usecase.retail.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Getter
@Setter
@Document(collection = "orders")
public class Order {
    public Order(String id,  String orderstatus, String userid,  List<Product> products) {
        this.id = id;
        this.orderstatus = orderstatus;
        this.userid = userid;
        this.products = products;
    }
    public Order() {
    }

    @Id
    private String id;

    private String orderstatus;

    private String userid;

    private List<Product> products;


}
