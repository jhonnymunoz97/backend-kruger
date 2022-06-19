package com.kruger.test.service.controller;

import com.kruger.test.core.service.DoseService;
import com.kruger.test.core.service.PersonaService;
import com.kruger.test.vo.request.FilterDateRequest;
import com.kruger.test.vo.response.FilterDateResponse;
import com.kruger.test.vo.response.FilterStateTypeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/filters")
public class FiltersController {

    @Autowired
    private DoseService doseService;
    @Autowired
    private PersonaService personaService;

    @GetMapping("/vaccinated")
    public ResponseEntity<?> showVacinated(){
        List<Tuple> results = this.personaService.findPersonByStateVaccination();
        List<FilterStateTypeResponse> list = new ArrayList<>();
        for (Tuple result:results){
            FilterStateTypeResponse p = new FilterStateTypeResponse();
            p.setId_person(Integer.parseInt(String.valueOf(result.get("id_person"))));
            p.setDni(String.valueOf(result.get("dni")));
            p.setFirst_name(String.valueOf(result.get("first_name")));
            p.setLast_name(String.valueOf(result.get("last_name")));
            p.setPhone(String.valueOf(result.get("phone")));
            p.setEmail(String.valueOf(result.get("email")));
            p.setDate_birth(String.valueOf(result.get("date_birth")));
            p.setDirection(String.valueOf(result.get("direction")));
            list.add(p);
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/vaccinated/{type}")
    public ResponseEntity<?> showVacinatedType(@PathVariable(value = "type") String type){
        List<Tuple> results = this.doseService.findPersonByTypeVaccine(type);
        List<FilterStateTypeResponse> list = new ArrayList<>();
        for (Tuple result:results){
            FilterStateTypeResponse p = new FilterStateTypeResponse();
            p.setId_person(Integer.parseInt(String.valueOf(result.get("id_person"))));
            p.setDni(String.valueOf(result.get("dni")));
            p.setFirst_name(String.valueOf(result.get("first_name")));
            p.setLast_name(String.valueOf(result.get("last_name")));
            p.setPhone(String.valueOf(result.get("phone")));
            p.setEmail(String.valueOf(result.get("email")));
            p.setDate_birth(String.valueOf(result.get("date_birth")));
            p.setDirection(String.valueOf(result.get("direction")));
            list.add(p);
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/vaccinated/dates")
    public ResponseEntity<?> showVacinatedType(@RequestBody FilterDateRequest filter){
        List<Tuple> results = this.doseService.findPersonByRangeVaccine(filter.getStart_date(),filter.getEnd_date());
        List<FilterDateResponse> list = new ArrayList<>();
        for (Tuple result:results){
            FilterDateResponse p = new FilterDateResponse();
            p.setId_person(Integer.parseInt(String.valueOf(result.get("id_person"))));
            p.setDni(String.valueOf(result.get("dni")));
            p.setFirst_name(String.valueOf(result.get("first_name")));
            p.setLast_name(String.valueOf(result.get("last_name")));
            p.setPhone(String.valueOf(result.get("phone")));
            p.setEmail(String.valueOf(result.get("email")));
            p.setDate_birth(String.valueOf(result.get("date_birth")));
            p.setDirection(String.valueOf(result.get("direction")));
            p.setDate_vaccination(String.valueOf(result.get("date_vaccination")));
            list.add(p);
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
