package com.cosmetika.api.mapper;

import com.cosmetika.api.model.person.Person;
import com.cosmetika.api.model.person.dto.CreatePersonRequest;
import com.cosmetika.api.model.person.dto.PersonResponse;
import com.cosmetika.api.utils.DocumentUtils;

public class PersonMapper {

    private PersonMapper() {
    }

    public static Person toEntity(CreatePersonRequest request) {
        Person person = new Person();

        if (request.getLegalName() != null)
            person.setLegalName(request.getLegalName());

        if (request.getTradeName() != null)
            person.setTradeName(request.getTradeName());

        if (request.getEmail() != null)
            person.setEmail(request.getEmail());

        if (request.getPhone() != null)
            person.setPhone(request.getPhone());

        if (request.getDocument() != null)
            person.setDocument(DocumentUtils.normalizeDocument(request.getDocument()));

        if (request.getIsCustomer() != null)
            person.setIsCustomer(request.getIsCustomer());

        if (request.getIsSupplier() != null)
            person.setIsSupplier(request.getIsSupplier());

        if (request.getAddress() != null)
            person.setAddress(request.getAddress());

        if (request.getCity() != null)
            person.setCity(request.getCity());

        if (request.getState() != null)
            person.setState(request.getState());

        if (request.getZipCode() != null)
            person.setZipCode(request.getZipCode());

        if (request.getNotes() != null)
            person.setNotes(request.getNotes());

        if (request.getActive() != null)
            person.setActive(request.getActive());

        return person;
    }

    public static void updateEntity(Person person, CreatePersonRequest request) {

        if (request.getLegalName() != null)
            person.setLegalName(request.getLegalName());

        if (request.getTradeName() != null)
            person.setTradeName(request.getTradeName());

        if (request.getEmail() != null)
            person.setEmail(request.getEmail());

        if (request.getPhone() != null)
            person.setPhone(request.getPhone());

        if (request.getDocument() != null)
            person.setDocument(DocumentUtils.normalizeDocument(request.getDocument()));

        if (request.getIsCustomer() != null)
            person.setIsCustomer(request.getIsCustomer());

        if (request.getIsSupplier() != null)
            person.setIsSupplier(request.getIsSupplier());

        if (request.getAddress() != null)
            person.setAddress(request.getAddress());

        if (request.getCity() != null)
            person.setCity(request.getCity());

        if (request.getState() != null)
            person.setState(request.getState());

        if (request.getZipCode() != null)
            person.setZipCode(request.getZipCode());

        if (request.getNotes() != null)
            person.setNotes(request.getNotes());

        if (request.getActive() != null)
            person.setActive(request.getActive());
    }

    public static PersonResponse toResponse(Person person) {
        return PersonResponse.builder()
                .id(person.getId())
                .legalName(person.getLegalName())
                .tradeName(person.getTradeName())
                .email(person.getEmail())
                .phone(person.getPhone())
                .document(person.getDocument())
                .isCustomer(person.getIsCustomer())
                .isSupplier(person.getIsSupplier())
                .address(person.getAddress())
                .city(person.getCity())
                .state(person.getState())
                .zipCode(person.getZipCode())
                .notes(person.getNotes())
                .active(person.getActive())
                .createdAt(person.getCreatedAt())
                .updatedAt(person.getUpdatedAt())
                .build();
    }

}
