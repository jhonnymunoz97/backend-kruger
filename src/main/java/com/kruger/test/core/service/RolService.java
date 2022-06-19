package com.kruger.test.core.service;

import com.kruger.test.client.entity.Rol;
import com.kruger.test.client.repository.IRolRepository;
import com.kruger.test.client.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RolService implements IRolService {

    @Autowired
    private IRolRepository repository;

    @Override
    public Rol create(Rol role) {
        return this.repository.save(role);
    }

    @Override
    public Rol update(Rol role) {
        return this.repository.save(role);
    }

    @Override
    public void delete(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Rol> findById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rol> findAll() {
        return this.repository.findAll();
    }
}
