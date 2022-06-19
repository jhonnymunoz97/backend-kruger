package com.kruger.test.client.service;

import com.kruger.test.client.entity.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService{

    Rol create(Rol role);
    Rol update(Rol role);
    void delete(Integer id);
    Optional<Rol> findById(Integer id);

    List<Rol> findAll();

}
