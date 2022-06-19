package com.kruger.test.core.service;

import com.kruger.test.client.entity.Dose;
import com.kruger.test.client.repository.IDoseRepository;
import com.kruger.test.client.service.IDoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DoseService implements IDoseService {
    @Autowired
    private IDoseRepository repository;

    @Override
    public Dose create(Dose dose) {
        return this.repository.save(dose);
    }

    @Override
    public Dose update(Dose dose) {
        return this.repository.save(dose);
    }

    @Override
    public void delete(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Dose> findById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Dose> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Tuple> findPersonByTypeVaccine(String type) {
        return this.repository.findPersonByTypeVaccine(type);
    }

    @Override
    public List<Tuple> findPersonByRangeVaccine(Date start_date, Date end_date) {
        return this.repository.findPersonByRangeVaccine(start_date,end_date);
    }
}
