package com.cosmetika.api.model.person.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePersonRequest {

    private String legalName;
    private String tradeName;
    private String email;
    private String phone;
    private String document;
    private Boolean isCustomer;
    private Boolean isSupplier;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String notes;
    private Boolean active;

}
