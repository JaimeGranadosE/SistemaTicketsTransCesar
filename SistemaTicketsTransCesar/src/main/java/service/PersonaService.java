/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Personal
 */

import model.Pasajero;
import model.Conductor;
import java.util.ArrayList;
import java.util.List;

public class PersonaService {
    private List<Pasajero> pasajeros = new ArrayList<>();
    private List<Conductor> conductores = new ArrayList<>();

    public void registrarPasajero(String cedula, String nombre, int tipo) {
        if (cedula == null || cedula.isEmpty() || nombre == null || nombre.isEmpty()) {
            System.out.println("Error: cédula y nombre no pueden estar vacíos.");
            return;
        }
        boolean existe = pasajeros.stream().anyMatch(p -> p.getCedula().equalsIgnoreCase(cedula));
        if (existe) {
            System.out.println("Error: ya existe un pasajero con esa cédula.");
            return;
        }
        if (tipo < 1 || tipo > 3) {
            System.out.println("Error: tipo de pasajero inválido (1-Regular, 2-Estudiante, 3-Adulto Mayor).");
            return;
        }
        Pasajero p = new Pasajero(cedula, nombre, tipo);
        pasajeros.add(p);
        System.out.println("Pasajero registrado: " + nombre);
    }

    public void registrarConductor(String cedula, String nombre, String licencia, String categoria) {
        if (cedula == null || cedula.isEmpty() || nombre == null || nombre.isEmpty()) {
            System.out.println("Error: cédula y nombre no pueden estar vacíos.");
            return;
        }
        boolean existe = conductores.stream().anyMatch(c -> c.getCedula().equalsIgnoreCase(cedula));
        if (existe) {
            System.out.println("Error: ya existe un conductor con esa cédula.");
            return;
        }
        Conductor c = new Conductor(nombre, cedula, licencia, categoria);
        conductores.add(c);
        System.out.println("Conductor registrado: " + nombre);
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public List<Conductor> getConductores() {
        return conductores;
    }
}