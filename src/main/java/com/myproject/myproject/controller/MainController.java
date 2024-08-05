package com.myproject.myproject.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.myproject.DTO.PersonDTO;
import com.myproject.myproject.entity.Person;
import com.myproject.myproject.repository.PersonRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {
    private final PersonRepo personRepo;
    private final ObjectMapper objectMapper;

    @PostMapping("/api/add")
    public void addPerson(@RequestBody PersonDTO personDTO){
       log.info("New row" + personRepo.save(
               Person.builder()
                       .age(personDTO.getAge())
                       .last_name(personDTO.getLast_name())
                       .first_name(personDTO.getFirst_name())
                       .build()));
    }
    @SneakyThrows
    @GetMapping("/api/all")
    public List<Person> getAll() {
        return personRepo.findAll();
    }

    @GetMapping("/api")
    public Person getPerson(@RequestParam int id){
        return personRepo.findById(id).orElseThrow();
    }

    @DeleteMapping("/api")
    public void deletePerson(@RequestParam int id) {
        personRepo.deleteById(id);
    }

    @PutMapping("/api/add")
    public String changePerson(@RequestBody Person person){
        if (!personRepo.existsById(person.getId())) {
            return "No such row";
        }
        return personRepo.save(person).toString();
    }

}
