package com.kruger.test.client.service;

import com.kruger.test.client.entity.Vacinne;

import java.util.List;
import java.util.Optional;

public interface IVaccineService {
    Vacinne create(Vacinne vaccine);
    Vacinne update(Vacinne vaccine);
    void delete(Integer id);
    Optional<Vacinne> findById(Integer id);

    List<Vacinne> findAll();
}
