package com.myproject.myproject.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name="Person", schema = "catalog")

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String last_name;
    private String first_name;
    private int age;

    public Person(String last_name, String first_name, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    public Person(){

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", age=" + age +
                '}';
    }
}
