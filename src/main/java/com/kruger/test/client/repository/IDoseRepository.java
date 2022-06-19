package com.kruger.test.client.repository;

import com.kruger.test.client.entity.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IDoseRepository extends JpaRepository<Dose,Integer> {

    List<Dose> findAll();

    Optional<Dose> findById(Integer id);

    Dose save(Dose dose);

    @Query(value = "select person.id_person,person.dni,person.first_name,person.last_name,person.phone,person.email,person.date_birth,person.direction from dose inner join person on person.id_person = dose.person_id inner join vaccine on dose.vacinne_id = vaccine.id_vaccine and vaccine.type =:type",nativeQuery = true)
    List<Tuple> findPersonByTypeVaccine(@Param("type") String type);

    @Query(value = "select person.id_person,person.dni,person.first_name,person.last_name,person.phone,person.email,person.date_birth,person.direction, dose.date_vaccination from dose inner join person on person.id_person = dose.person_id and dose.date_vaccination BETWEEN :start_date and :end_date",nativeQuery = true)
    List<Tuple> findPersonByRangeVaccine(@Param("start_date") Date start_date, @Param("end_date") Date end_date);
}
