package com.example.dataclouderrest.repositories;

import com.example.dataclouderrest.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long> {
    public abstract Optional<ArrayList<UsuarioModel>> findAllByPrioridad(Integer prioridad);
}
