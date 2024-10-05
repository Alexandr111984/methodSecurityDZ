package ru.netology.methodSecurityDZ.controller;


import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.netology.methodSecurityDZ.entity.Persons;
import ru.netology.methodSecurityDZ.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private final PersonsService personsService;

    public Controller(PersonsService personsService) {

        this.personsService = personsService;
    }


    @GetMapping(value = "/persons/by-city_of_living")
    public List<Persons> getPersons(@RequestParam("cityOfLiving") String cityOfLiving) {

        return personsService.getByCityOfLiving(cityOfLiving);
    }

    @GetMapping("/persons/by-age")
    public List<Persons> getPersons(@RequestParam("age") int age) {

        return personsService.getByAgeLessThan(age);
    }

    @GetMapping(value = "/persons/by")
    public Optional<Persons> getPersons(@RequestParam("name") String name, @RequestParam("surname") String surname) {

        return personsService.getByNameAndSurname(name, surname);
    }

    @GetMapping("/hello-alex")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('DELETE')")
    public String getAlex() {
        return "Hello User or Alex";
    }


    @GetMapping("/hello-user")
    @RolesAllowed("ROLE_WRITE")
    public String getUser() {

        return "Hello User";
    }


    @GetMapping("/hello-admin")
    @org.springframework.security.access.annotation.Secured("ROLE_READ")
    public String getAdmin() {

        return "Hello Admin";
    }

   // Principal principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();


}
