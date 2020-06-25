package com.github.classificadosamac.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.classificadosamac.api.model.Service;

public class ServiceDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("seller")
    @JsonIgnoreProperties({"products", "services"})
    private UserDTO seller;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("investment")
    private String investment;

    public ServiceDTO() { }

    public ServiceDTO(Service service) {
        this.id = service.getId();
        this.seller = new UserDTO(service.getSeller());
        this.name = service.getName();
        this.description = service.getDescription();
        this.investment = service.getInvestment();
    }
}
