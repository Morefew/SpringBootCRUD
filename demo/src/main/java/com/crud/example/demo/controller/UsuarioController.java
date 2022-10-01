/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.example.demo.controller;

import com.crud.example.demo.repository.UsuarioRepository;
import com.crud.example.demo.entity.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Lenny Gonzalez
 */

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> getAll(){

        return (List<Usuario>)usuarioRepository.findAll();
    }

//    @PostMapping("/save")
//    @ResponseStatus(HttpStatus.CREATED)
//    public {
//        return usuarioRepository.save(usuario);
//    }

    @GetMapping("getid/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario getUsuario(@PathVariable("id") Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    @GetMapping("getnombre/{nombre}")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> getUsuarioByNombre(@PathVariable("nombre") String nombre)
    {
        return (List<Usuario>) usuarioRepository.findByNombre(nombre);
    }

    @GetMapping("getapellido/{apellido}")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> getUsuarioByApellido(@PathVariable("apellido") String apellido)
    {
        return (List<Usuario>) usuarioRepository.findByApellido(apellido);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@PathVariable("id") Long id, @RequestBody Usuario usuario){
      Usuario usuarioUpdate = usuarioRepository.findById(id).orElse(null);
      usuarioUpdate.setNombre(usuario.getNombre());
      usuarioUpdate.setApellido(usuario.getApellido());
      return usuarioRepository.save(usuarioUpdate);
        }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id")Long id) {
        Usuario usuarioDelete = usuarioRepository.findById(id).orElse(null);
        usuarioDelete.setEstado(false);
        usuarioRepository.save(usuarioDelete);
    }

}
