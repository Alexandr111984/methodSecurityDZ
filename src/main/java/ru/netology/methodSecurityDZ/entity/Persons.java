package ru.netology.methodSecurityDZ.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;


@Getter
@Setter
@Entity
@Table(name = "persons")

public class Persons {

    @Column(name = "age")
    private Integer age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "city_of_living")
    private String cityOfLiving;

    @Column(name = "phone_number")
    private String phone_number;


    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;


    @Override
    public String toString() {
        return "Persons{" +
                "age=" + age +
                ", id=" + id +
                ", cityOfLiving='" + cityOfLiving + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}