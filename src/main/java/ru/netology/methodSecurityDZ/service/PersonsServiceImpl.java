package ru.netology.methodSecurityDZ.service;

import ru.netology.methodSecurityDZ.entity.Persons;
import ru.netology.methodSecurityDZ.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)

public class PersonsServiceImpl implements PersonsService {
    @Autowired
    private PersonsRepository personsRepository;


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
