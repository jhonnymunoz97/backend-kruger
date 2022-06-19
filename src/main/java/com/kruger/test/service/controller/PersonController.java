package com.kruger.test.service.controller;

import com.kruger.test.client.entity.Persona;
import com.kruger.test.core.service.PersonaService;
import com.kruger.test.core.service.RolService;
import com.kruger.test.service.errors.ErrorResponse;
import com.kruger.test.vo.request.PersonRequest;
import com.kruger.test.vo.request.PersonUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonaService personService;

    @Autowired
    private RolService roleService;

    @GetMapping("/all")
    public List<Persona> findAllRoles(){
        return this.personService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Persona> findRoleById(@PathVariable(value = "id") Integer id){
        return this.personService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PersonRequest person){
        ErrorController errorC = new ErrorController();
        ErrorResponse errorR = new ErrorResponse();
        if(!errorC.campoRequerido(person.getDni()) || !errorC.campoRequerido(person.getEmail()) || !errorC.campoRequerido(person.getFirst_name()) || !errorC.campoRequerido(person.getLast_name())){
            return errorR.requerido();
        }
        if(!errorC.soloNumeros(person.getDni())) {
            return errorR.cedula();
        }
        if(!errorC.longitudCedula(person.getDni())) {
            return errorR.cedulaLongitud();
        }
        if(!errorC.validarEmail(person.getEmail())) {
            return errorR.email();
        }
        if(!errorC.letras(person.getFirst_name()) || !errorC.letras(person.getLast_name()) ) {
            return errorR.cadena();
        }
        Persona persona = new Persona();
        persona.setDni(person.getDni());
        persona.setEmail(person.getEmail());
        persona.setFirst_name(person.getFirst_name());
        persona.setLast_name(person.getLast_name());
        persona.setUser_name(person.getFirst_name().toLowerCase() + '_' + person.getLast_name().substring(0,1).toLowerCase());
        persona.setUser_password(person.getFirst_name().toLowerCase() + person.getDni().substring(person.getDni().length()-4,person.getDni().length()) + '@');
        persona.setRole(roleService.findById(person.getRole_id()).get());
        persona.setStatus_vaccination(false);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.personService.create(persona));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody PersonRequest person,@PathVariable(value = "id") Integer id){
        ErrorController errorC = new ErrorController();
        ErrorResponse errorR = new ErrorResponse();
        if(!errorC.campoRequerido(person.getDni()) || !errorC.campoRequerido(person.getEmail()) || !errorC.campoRequerido(person.getFirst_name()) || !errorC.campoRequerido(person.getLast_name())){
            return errorR.requerido();
        }
        if(!errorC.soloNumeros(person.getDni())) {
            return errorR.cedula();
        }
        if(!errorC.longitudCedula(person.getDni())) {
            return errorR.cedulaLongitud();
        }
        if(!errorC.validarEmail(person.getEmail())) {
            return errorR.email();
        }
        if(!errorC.letras(person.getFirst_name()) || !errorC.letras(person.getLast_name()) ) {
            return errorR.cadena();
        }
        Persona personaOld = this.personService.findById(id).get();
        personaOld.setEmail(person.getEmail());
        personaOld.setDni(person.getDni());
        personaOld.setFirst_name(person.getFirst_name());
        personaOld.setLast_name(person.getLast_name());
        personaOld.setRole(roleService.findById(person.getRole_id()).get());
        return ResponseEntity.status(HttpStatus.OK).body(this.personService.update(personaOld));
    }

    @PutMapping("/update-employe/{id}")
    public ResponseEntity<?> updateEmploye(@RequestBody PersonUpdateRequest person, @PathVariable(value = "id") Integer id){
        ErrorController errorC = new ErrorController();
        ErrorResponse errorR = new ErrorResponse();
        if(!errorC.campoRequerido(person.getDirection()) || !errorC.campoRequerido(person.getPhone()) || person.getDate_birth()==null ) {
            return errorR.requeridoUpdate();
        }
        Persona personaOld = this.personService.findById(id).get();
        personaOld.setPhone(person.getPhone());
        personaOld.setDirection(person.getDirection());
        personaOld.setDate_birth(person.getDate_birth());
        return ResponseEntity.status(HttpStatus.OK).body(this.personService.update(personaOld));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        this.personService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Registro eliminado");
    }


}
