package ru.netology.methodSecurityDZ.service;

import ru.netology.methodSecurityDZ.entity.Persons;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PersonsService {


    List<Persons> getByCityOfLiving(String cityOfLiving);

    List<Persons> getByAgeLessThan(int age);


    @Transactional
    void add(Persons persons);


    Optional<Persons> getByNameAndSurname(String name, String surname);

}

