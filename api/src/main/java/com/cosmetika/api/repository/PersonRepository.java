package com.cosmetika.api.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetika.api.model.person.Person;

public interface PersonRepository extends JpaRepository<Person, UUID> {

    Optional<Person> findByDocument(String document);

}
