package ru.netology.methodSecurityDZ.controller;


import jakarta.annotation.security.RolesAllowed;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import ru.netology.methodSecurityDZ.entity.Persons;
import ru.netology.methodSecurityDZ.repository.PersonsRepository;
import ru.netology.methodSecurityDZ.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private PersonsService personsService;

    @Autowired
    private PersonsRepository personsRepository;


    public Controller(PersonsService personsService) {

        this.personsService = personsService;
    }


//    @GetMapping(value = "/persons/by-city_of_living")
//    public List<Persons> getPersons(@RequestParam("cityOfLiving") String cityOfLiving) {
//
//        return personsService.getByCityOfLiving(cityOfLiving);
//    }
//
//    @GetMapping("/persons/by-age")
//    public List<Persons> getPersons(@RequestParam("age") int age) {
//
//        return personsService.getByAgeLessThan(age);
//    }
//
//    @GetMapping(value = "/persons/by")
//    public Optional<Persons> getPersons(@RequestParam("name") String name, @RequestParam("surname") String surname) {
//
//        return personsService.getByNameAndSurname(name, surname);
//    }

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


    @GetMapping("/authentication/by-username")
    @PreAuthorize("#username==authentication.principal.username")
    public String greetingUser(@RequestParam("username") String username) {

        return "hello User " + username;
    }


}
