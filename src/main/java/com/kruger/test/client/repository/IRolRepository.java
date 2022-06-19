package com.kruger.test.client.repository;

import com.kruger.test.client.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRolRepository extends JpaRepository<Rol,Integer> {

    List<Rol> findAll();
    Optional<Rol> findById(Integer id);

    Rol save(Rol role);


}
