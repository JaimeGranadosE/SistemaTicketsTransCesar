package com.mycompany.sistematicketstranscesar.service;

public class PersonaService {

    public void registrarConductor(String cedula, String nombre, String licencia, String categoria) {
        System.out.println("Conductor registrado: " + nombre);
    }

    public void registrarPasajero(String cedula, String nombre, int tipo) {
        System.out.println("Pasajero registrado: " + nombre);
    }

}