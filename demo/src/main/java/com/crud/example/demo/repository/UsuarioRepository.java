/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.example.demo.repository;

import com.crud.example.demo.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lenny Gonzalez
 */

@Repository // Descripcion de queries a la base de datos
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

    Iterable<Usuario> findByNombre(String nombre);

   Iterable<Usuario> findByApellido(String apellido);
}
