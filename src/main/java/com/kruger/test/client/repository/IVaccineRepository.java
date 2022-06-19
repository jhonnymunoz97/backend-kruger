package com.kruger.test.client.repository;

import com.kruger.test.client.entity.Vacinne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IVaccineRepository extends JpaRepository<Vacinne,Integer> {

    List<Vacinne> findAll();

    Optional<Vacinne> findById(Integer id);

    Vacinne save(Vacinne vaccine);
}
