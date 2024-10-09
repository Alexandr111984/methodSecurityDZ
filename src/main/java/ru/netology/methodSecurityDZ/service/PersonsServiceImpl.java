package ru.netology.methodSecurityDZ.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.netology.methodSecurityDZ.entity.Persons;
//import ru.netology.methodSecurityDZ.entity.Role;
import ru.netology.methodSecurityDZ.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor


public class PersonsServiceImpl implements PersonsService {



    private PersonsRepository personsRepository;

    @Autowired
    public void setPersonsRepository(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }


    @Override
    public List<Persons> getByCityOfLiving(String cityOfLiving) {

        return personsRepository.findByCityOfLiving(cityOfLiving);
    }

    @Override
    public List<Persons> getByAgeLessThan(int age) {

        return personsRepository.findByAgeLessThan(age);
    }

    @Override
    @Transactional
    public void add(Persons persons) {
        personsRepository.save(persons);
    }

    @Override
    public Optional<Persons> getByNameAndSurname(String name, String surname) {

        return personsRepository.findByNameAndSurname(name, surname);
    }



}
