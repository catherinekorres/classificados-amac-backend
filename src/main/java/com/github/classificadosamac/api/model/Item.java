package com.github.classificadosamac.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@MappedSuperclass
public class Item {
    @ManyToOne
    @JoinColumn(name="seller_id")
    @JsonIgnoreProperties({"products", "services"})
    private User seller;
    @Column
    private String name;
    @Column
    private String description;

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
