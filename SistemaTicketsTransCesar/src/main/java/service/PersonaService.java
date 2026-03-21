/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Personal
 */

import java.util.ArrayList;
import java.util.List;
import model.Conductor;
import model.Pasajero;

public class PersonaService {
    private List<Conductor> conductores = new ArrayList<>();
    private List<Pasajero> pasajeros = new ArrayList<>();

    public void registrarConductor(Conductor c) {
        conductores.add(c);
        System.out.println("Conductor registrado: " + c.getNombre());
    }

    public void registrarPasajero(Pasajero p) {
        pasajeros.add(p);
        System.out.println("Pasajero registrado: " + p.getNombre());
    }
    
    public void registrarConductor(String cedula, String nombre, String licencia, String categoria) {
        Conductor c = new Conductor(nombre, cedula, licencia);
        conductores.add(c);
        System.out.println("Conductor registrado: " + c.getNombre() + " (" + categoria + ")");
    }

    public void registrarPasajero(String cedula, String nombre, int tipo) {
        String tipoStr = (tipo == 1) ? "Regular" : (tipo == 2) ? "Estudiante" : "Adulto Mayor";
        Pasajero p = new Pasajero(nombre, cedula, tipoStr);
        pasajeros.add(p);
        System.out.println("Pasajero registrado: " + p.getNombre() + " (" + tipoStr + ")");
    }

    public List<Conductor> getConductores() {
        return conductores;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }
}