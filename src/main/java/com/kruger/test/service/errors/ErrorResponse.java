package com.kruger.test.service.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {

    public ResponseEntity<?> requerido(){
        Map<String,Object> response = new HashMap<>();
        response.put("message", "Los datos de la cédula,nombres,apellidos y correo son requeridos.");
        response.put("code","200");
        response.put("status","success");
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> requeridoUpdate(){
        Map<String,Object> response = new HashMap<>();
        response.put("message", "Los datos de la dirección,teléfono,fecha de nacimiento y estado de vacunación son requeridos.");
        response.put("code","200");
        response.put("status","success");
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }

    public ResponseEntity<?> cedula(){
        Map<String,Object> response = new HashMap<>();
        response.put("message", "La cédula debe ser un valor numérico");
        response.put("code","200");
        response.put("status","success");
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }

    public ResponseEntity<?> cedulaLongitud(){
        Map<String,Object> response = new HashMap<>();
        response.put("message", "La cédula debe ser de 10 caracteres");
        response.put("code","200");
        response.put("status","success");
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }

    public ResponseEntity<?> email(){
        Map<String,Object> response = new HashMap<>();
        response.put("message", "Debe ser un email válido.");
        response.put("code","200");
        response.put("status","success");
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }

    public ResponseEntity<?> cadena(){
        Map<String,Object> response = new HashMap<>();
        response.put("message", "Los valores para nombres y apellidos no deben tener ni números ni caracteres especiales");
        response.put("code","200");
        response.put("status","success");
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }

    public ResponseEntity<?> vacuna(){
        Map<String,Object> response = new HashMap<>();
        response.put("message","La vacuna sólo puede ser Sputnik, AstraZeneca, Pfizer o Jhonson&Jhonson");
        response.put("code","200");
        response.put("status","success");
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
}
