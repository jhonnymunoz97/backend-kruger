package com.kruger.test.service.controller;

import com.kruger.test.client.entity.Dose;
import com.kruger.test.client.entity.Persona;
import com.kruger.test.core.service.DoseService;
import com.kruger.test.core.service.PersonaService;
import com.kruger.test.core.service.VaccineService;
import com.kruger.test.vo.request.DoseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dose")
public class DoseController {
    @Autowired
    private DoseService doseService;

    @Autowired
    private PersonaService personService;

    @Autowired
    private VaccineService vaccineService;

    @GetMapping("/all")
    public List<Dose> findAllRoles(){
        return this.doseService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Dose> findRoleById(@PathVariable(value = "id") Integer id){
        return this.doseService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody DoseRequest dose){
        Dose dose_aux = new Dose();
        dose_aux.setNro_dose(dose.getNro_dose());
        dose_aux.setDate_vaccination(dose.getDate_vaccination());
        dose_aux.setVacinne(this.vaccineService.findById(dose.getId_vaccine()).get());
        dose_aux.setPerson(this.personService.findById(dose.getId_person()).get());
        Persona personaOld = this.personService.findById(dose.getId_person()).get();
        personaOld.setStatus_vaccination(true);
        this.personService.update(personaOld);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.doseService.create(dose_aux));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmploye(@RequestBody DoseRequest dose, @PathVariable(value = "id") Integer id){
        Dose dose_aux = this.doseService.findById(id).get();
        dose_aux.setNro_dose(dose.getNro_dose());
        dose_aux.setDate_vaccination(dose.getDate_vaccination());
        dose_aux.setVacinne(this.vaccineService.findById(dose.getId_vaccine()).get());
        dose_aux.setPerson(this.personService.findById(dose.getId_person()).get());
        Persona personaOld = this.personService.findById(dose.getId_person()).get();
        personaOld.setStatus_vaccination(true);
        this.personService.update(personaOld);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.doseService.update(dose_aux));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        this.doseService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Registro eliminado");
    }

}
