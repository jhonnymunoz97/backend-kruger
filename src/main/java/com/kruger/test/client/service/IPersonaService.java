package com.kruger.test.client.service;

import com.kruger.test.client.entity.Persona;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

public interface IPersonaService {

    Persona create(Persona persona);
    Persona update(Persona persona);
    void delete(Integer id);
    Optional<Persona> findById(Integer id);

    List<Persona> findAll();

    List<Tuple> findPersonByStateVaccination();

}
