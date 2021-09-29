package com.usecase.retail.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "product")
public class Product {
    public Product( String itemname, Long price, Long quantity) {

        this.itemname = itemname;
        this.price = price;
        this.quantity = quantity;

    }
    public Product() {
    }
    private String itemname;
    private Long price;
    private Long quantity;


}
