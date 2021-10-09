package com.example.dataclouderrest.services;

import com.example.dataclouderrest.models.UsuarioModel;
import com.example.dataclouderrest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;


    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public Optional<ArrayList<UsuarioModel>> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.findAllByPrioridad(prioridad);
    }

    public boolean eliminarPorId(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }    }


    }
