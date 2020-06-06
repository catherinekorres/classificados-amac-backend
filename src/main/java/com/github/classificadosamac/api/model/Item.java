package com.github.classificadosamac.api.model;

import javax.persistence.*;

public class Item {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User seller;
    private String name;
    private String Description;

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
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
