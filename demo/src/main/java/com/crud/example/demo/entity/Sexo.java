package com.crud.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "sexo")
@Getter
@Setter
public class Sexo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sexo", nullable = false, unique = true)
    private Long id;

    private String description;


}
