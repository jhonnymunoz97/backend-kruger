package com.kruger.test.service.controller;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrorController {

    public boolean letras(String campo) {
        Pattern patron = Pattern.compile("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+");
        Matcher comprobar = patron.matcher(campo);
        if(comprobar.matches()) return true;
        else return false;
    }

    public boolean soloNumeros(String cedula) {
        if(!cedula.matches("[+-]?\\d*(\\.\\d+)?")) return false;
        else return true;
    }

    public boolean longitudCedula(String cedula) {
        if(cedula.length()<10 || cedula.length()>10) return false;
        else return true;
    }

    public boolean campoRequerido(String campo) {
        if(campo.length()<1) return false;
        else return true;
    }

    public boolean validarEmail(String email) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        if(mather.find()) return true;
        else return false;
    }

}
