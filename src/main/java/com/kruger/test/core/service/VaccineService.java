package com.kruger.test.core.service;

import com.kruger.test.client.entity.Vacinne;
import com.kruger.test.client.repository.IVaccineRepository;
import com.kruger.test.client.service.IVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VaccineService implements IVaccineService {
    @Autowired
    private IVaccineRepository repository;

    @Override
    public Vacinne create(Vacinne vaccine) {
        return this.repository.save(vaccine);
    }

    @Override
    public Vacinne update(Vacinne vaccine) {

        return this.repository.save(vaccine);
    }

    @Override
    public void delete(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Vacinne> findById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vacinne> findAll() {
        return this.repository.findAll();
    }
}
