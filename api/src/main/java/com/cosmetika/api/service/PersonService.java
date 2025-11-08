package com.cosmetika.api.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosmetika.api.mapper.PersonMapper;
import com.cosmetika.api.model.person.Person;
import com.cosmetika.api.model.person.dto.CreatePersonRequest;
import com.cosmetika.api.model.person.dto.PersonResponse;
import com.cosmetika.api.repository.PersonRepository;
import com.cosmetika.api.utils.DocumentUtils;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @SuppressWarnings("null")
    @Transactional
    public PersonResponse create(CreatePersonRequest request) {
        if (request == null)
            throw new IllegalArgumentException("Request cannot be empty");

        String normalizedDocument = DocumentUtils.normalizeDocument(request.getDocument());
        if (personRepository.findByDocument(normalizedDocument).isPresent())
            throw new IllegalArgumentException("Person with this Document already exists");

        Person person = PersonMapper.toEntity(request);
        Person savedPerson = personRepository.save(person);

        return PersonMapper.toResponse(savedPerson);
    }

    @SuppressWarnings("null")
    @Transactional(readOnly = true)
    public PersonResponse findById(UUID id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found with id: " + id));
        return PersonMapper.toResponse(person);
    }

    @Transactional(readOnly = true)
    public PersonResponse findByDocument(String document) {
        Person person = personRepository.findByDocument(document)
                .orElseThrow(() -> new IllegalArgumentException("Person not found with Document: " + document));
        return PersonMapper.toResponse(person);
    }

    @Transactional(readOnly = true)
    public List<PersonResponse> findAll() {
        return personRepository.findAll()
                .stream()
                .map(PersonMapper::toResponse)
                .collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Transactional
    public PersonResponse update(UUID id, CreatePersonRequest request) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found with id: " + id));

        // validate unique document if changed
        String normalizedDocument = DocumentUtils.normalizeDocument(request.getDocument());
        if (normalizedDocument != null && !normalizedDocument.equals(person.getDocument())) {
            if (personRepository.findByDocument(request.getDocument()).isPresent()) {
                throw new IllegalArgumentException("Person with this Document already exists");
            }
        }

        System.out.println(request);

        PersonMapper.updateEntity(person, request);
        Person updatedPerson = personRepository.save(person);

        return PersonMapper.toResponse(updatedPerson);
    }

    @SuppressWarnings("null")
    @Transactional
    public void delete(UUID id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found with id: " + id));
        personRepository.delete(person);
    }

}
