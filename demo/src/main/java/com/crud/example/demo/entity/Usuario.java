/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.example.demo.entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Lenny Gonzalez
 */

@Entity
@Table(name="usuario") // este comando crea la columna en la base de dato
@Getter
@Setter
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "Id", nullable = false, unique = true)
    private Long id;
    
    @Column(name= "nombre") // este comando crea la columna en la base de dato
    private String nombre;
    
    @Column(name= "apellido") // este comando crea la columna en la base de dato
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "sexo_id")
    private Sexo sexo;

    @Column(name= "estado")
    private boolean estado;

    
}
