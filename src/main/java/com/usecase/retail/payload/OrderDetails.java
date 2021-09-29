package com.usecase.retail.payload;

import com.usecase.retail.models.Product;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Getter
@Setter
public class OrderDetails {
    public OrderDetails() {
    }

    @NotBlank
    private String userid;
    private List<Product> products;

    public OrderDetails(String userid, List<Product> products) {
        this.userid = userid;
        this.products = products;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }




}
