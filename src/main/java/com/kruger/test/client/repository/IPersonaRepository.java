package com.kruger.test.client.repository;

import com.kruger.test.client.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Integer> {
    List<Persona> findAll();
    Optional<Persona> findById(Integer id);

    Persona save(Persona role);


    @Query(value = "select person.id_person,person.dni,person.first_name,person.last_name,person.phone,person.email,person.date_birth,person.direction from person where id_person IN (select person_id from dose)",nativeQuery = true)
    List<Tuple> findPersonByStateVaccination();
}
