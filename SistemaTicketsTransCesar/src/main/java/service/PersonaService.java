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

    public List<Conductor> getConductores() { return conductores; }
    public List<Pasajero> getPasajeros() { return pasajeros; }
}