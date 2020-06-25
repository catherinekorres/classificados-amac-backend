package com.github.classificadosamac.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.classificadosamac.api.model.Product;

public class ProductDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("seller")
    @JsonIgnoreProperties({"products", "services"})
    private UserDTO seller;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private double price;

    public ProductDTO() { }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.seller = new UserDTO(product.getSeller());
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }

}
