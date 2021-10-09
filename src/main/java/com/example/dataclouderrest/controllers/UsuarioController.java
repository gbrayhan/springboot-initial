package com.example.dataclouderrest.controllers;


import com.example.dataclouderrest.models.UsuarioModel;
import com.example.dataclouderrest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;


    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping(path="/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return usuarioService.obtenerPorId(id);
    }
    // @GetMapping(path="/prioridad/{id}")
    @GetMapping(path="/query")
    public Optional<ArrayList<UsuarioModel>> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return usuarioService.obtenerPorPrioridad(prioridad);
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @DeleteMapping(path="/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = usuarioService.eliminarPorId(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id " + id;
        }

    }



}
