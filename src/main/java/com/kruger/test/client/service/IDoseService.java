package com.kruger.test.client.service;

import com.kruger.test.client.entity.Dose;

import javax.persistence.Tuple;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IDoseService {
    Dose create(Dose dose);
    Dose update(Dose dose);
    void delete(Integer id);
    Optional<Dose> findById(Integer id);
    List<Dose> findAll();

    List<Tuple> findPersonByTypeVaccine(String type);

    List<Tuple> findPersonByRangeVaccine(Date start_date, Date end_date);

}
