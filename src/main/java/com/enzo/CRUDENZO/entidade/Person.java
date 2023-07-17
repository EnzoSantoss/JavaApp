package com.enzo.CRUDENZO.entidade;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_people")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
     private Long id;

    @Column(name= "name", nullable = false)
    private String name;

    @Column(name= "cpf", nullable = false, unique = true)
    private  String cpf;

    @Column(name= "age", nullable = false)
    private Integer age;


    public Person(){

    }
    @Builder
    public Person(String name, String cpf, Integer age) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }
}
