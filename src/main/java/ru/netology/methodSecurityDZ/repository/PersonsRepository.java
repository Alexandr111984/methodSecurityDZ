package ru.netology.methodSecurityDZ.repository;

import ru.netology.methodSecurityDZ.entity.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface PersonsRepository extends JpaRepository<Persons, Integer> {

    @Query("select p from Persons p where p.cityOfLiving =:cityOfLiving")
    List<Persons> findByCityOfLiving(@Param("cityOfLiving") String cityOfLiving);


    @Query("select p from Persons p where p.name = :name and p.surname = :surname")
    Optional<Persons> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

    @Query("select p from Persons p where p.age > :age")
    List<Persons> findByAgeLessThan(@Param("age") Integer age);


}

