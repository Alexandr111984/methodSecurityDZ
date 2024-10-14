package ru.netology.methodSecurityDZ;


import org.springframework.boot.CommandLineRunner;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.netology.methodSecurityDZ.entity.Persons;
import ru.netology.methodSecurityDZ.repository.PersonsRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@EnableMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
@RequiredArgsConstructor
class MethodSecurityDZApplication  {
    private final PersonsRepository personsRepository;


    public static void main(String[] args) {

        SpringApplication.run(MethodSecurityDZApplication.class, args);

    }

//    @Override
//    public void run(String... args) throws Exception {
//        Persons persons = new Persons();
//        persons.setName("Alex");
//        persons.setSurname("Ivanov");
//        persons.setAge(13);
//        persons.setPhone_number("8-913-666-88-99");
//        persons.setCityOfLiving("Moscow");
//        System.out.println(persons);
//        Persons persons1 = new Persons();
//        persons1.setName("Alexey");
//        persons1.setSurname("Petrov");
//        persons1.setAge(23);
//        persons1.setPhone_number("8-913-666-99-00");
//        persons1.setCityOfLiving("Omsk");
//        System.out.println(persons1);
//        Persons persons2 = new Persons();
//        persons2.setName("Igor");
//        persons2.setSurname("Petin");
//        persons2.setAge(29);
//        persons2.setPhone_number("8-923-678-99-00");
//        persons2.setCityOfLiving("Tomsk");
//        System.out.println(persons2);
//        Persons persons3 = new Persons();
//        persons3.setName("Ivan");
//        persons3.setSurname("Sergeev");
//        persons3.setAge(33);
//        persons3.setPhone_number("8-923-999-99-99");
//        persons3.setCityOfLiving("Tomsk");
//        System.out.println(persons3);
//        personsRepository.save(persons);
//        personsRepository.save(persons1);
//        personsRepository.save(persons2);
//        personsRepository.save(persons3);
//
//
//    }


}
