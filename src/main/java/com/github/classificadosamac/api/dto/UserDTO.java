package com.github.classificadosamac.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.classificadosamac.api.model.Product;
import com.github.classificadosamac.api.model.Service;
import com.github.classificadosamac.api.model.User;

import java.util.List;

public class UserDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("whatsApp")
    private String whatsApp;

    @JsonProperty("street")
    private String street;

    @JsonProperty("number")
    private int number;

    @JsonProperty("products")
    @JsonIgnoreProperties({"seller"})
    private List<Product> products;

    @JsonProperty("services")
    @JsonIgnoreProperties({"seller"})
    private List<Service> services;

    public UserDTO() { }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.whatsApp = user.getWhatsApp();
        this.street = user.getStreet();
        this.number = user.getNumber();
        this.products = user.getProducts();
        this.services = user.getServices();
    }

}
