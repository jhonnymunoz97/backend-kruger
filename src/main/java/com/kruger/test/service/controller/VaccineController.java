package com.kruger.test.service.controller;

import com.kruger.test.client.entity.Rol;
import com.kruger.test.client.entity.Vacinne;
import com.kruger.test.core.service.VaccineService;
import com.kruger.test.service.errors.ErrorResponse;
import com.kruger.test.vo.request.RoleRequest;
import com.kruger.test.vo.request.VaccineRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vaccine")
public class VaccineController {
    @Autowired
    private VaccineService vaccineService;

    @GetMapping("/all")
    public List<Vacinne> findAllRoles(){
        return this.vaccineService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Vacinne> findRoleById(@PathVariable(value = "id") Integer id){
        return this.vaccineService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody VaccineRequest vaccineR){
        ErrorResponse error = new ErrorResponse();
        if(vaccineR.getType().toLowerCase().equals("Sputnik".toLowerCase())==false && vaccineR.getType().toLowerCase().equals("AstraZeneca".toLowerCase())==false && vaccineR.getType().toLowerCase().equals("Pfizer".toLowerCase())==false && vaccineR.getType().toLowerCase().equals("Jhonson&Jhonson".toLowerCase())==false){
            return error.vacuna();
        }
        Vacinne vaccine = new Vacinne();
        vaccine.setType(vaccineR.getType());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.vaccineService.create(vaccine));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody VaccineRequest vaccine, @PathVariable(value = "id") Integer id){
        ErrorResponse error = new ErrorResponse();
        if(vaccine.getType().toLowerCase().equals("Sputnik".toLowerCase())==false && vaccine.getType().toLowerCase().equals("AstraZeneca".toLowerCase())==false && vaccine.getType().toLowerCase().equals("Pfizer".toLowerCase())==false && vaccine.getType().toLowerCase().equals("Jhonson&Jhonson".toLowerCase())==false){
            return error.vacuna();
        }
        Vacinne vaccineOld = this.vaccineService.findById(id).get();
        vaccineOld.setType(vaccine.getType());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.vaccineService.update(vaccineOld));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        this.vaccineService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Registro eliminado");
    }

}
