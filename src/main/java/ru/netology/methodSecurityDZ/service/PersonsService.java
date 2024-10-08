package ru.netology.methodSecurityDZ.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.netology.methodSecurityDZ.entity.Persons;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PersonsService extends UserDetailsService {


    List<Persons> getByCityOfLiving(String cityOfLiving);

    List<Persons> getByAgeLessThan(int age);


    @Transactional
    void add(Persons persons);


    Optional<Persons> getByNameAndSurname(String name, String surname);

    Persons findByName(String name);


}

