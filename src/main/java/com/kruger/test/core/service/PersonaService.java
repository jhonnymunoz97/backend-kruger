package com.kruger.test.core.service;

import com.kruger.test.client.entity.Persona;
import com.kruger.test.client.repository.IPersonaRepository;
import com.kruger.test.client.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    private IPersonaRepository repository;

    @Override
    public Persona create(Persona persona) {
        return this.repository.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        return this.repository.save(persona);
    }

    @Override
    public void delete(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return this.repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tuple> findPersonByStateVaccination() {
        return this.repository.findPersonByStateVaccination();
    }

}
