package com.mycompany.sistematicketstranscesar.service;

import com.mycompany.sistematicketstranscesar.dao.PersonaDAO;

public class PersonaService {

    private PersonaDAO dao = new PersonaDAO();

    public void registrarConductor(String cedula, String nombre, String licencia, String categoria) {

        // 🔴 Validaciones básicas
        if (cedula == null || cedula.isEmpty()) {
            System.out.println("Error: cédula vacía");
            return;
        }

        if (nombre == null || nombre.isEmpty()) {
            System.out.println("Error: nombre vacío");
            return;
        }

        if (licencia == null || licencia.isEmpty()) {
            System.out.println("Error: licencia vacía");
            return;
        }

        if (categoria == null || categoria.isEmpty()) {
            System.out.println("Error: categoría vacía");
            return;
        }

        // 🔴 Validar cédula repetida
        for (String p : dao.cargarPersonas()) {
            String[] datos = p.split(";");
            if (datos.length >= 2 && datos[1].equals(cedula)) {
                System.out.println("Error: ya existe una persona con esa cédula");
                return;
            }
        }

        // 🔴 Validar categoría (ejemplo básico)
        if (!categoria.matches("[BC][12]")) {
            System.out.println("Error: categoría inválida (B1, B2, C1, C2)");
            return;
        }

        dao.guardarPersona("CONDUCTOR", cedula, nombre, licencia + "-" + categoria);

        System.out.println("Conductor registrado correctamente");
    }

    public void registrarPasajero(String cedula, String nombre, int tipo) {

        // 🔴 Validaciones básicas
        if (cedula == null || cedula.isEmpty()) {
            System.out.println("Error: cédula vacía");
            return;
        }

        if (nombre == null || nombre.isEmpty()) {
            System.out.println("Error: nombre vacío");
            return;
        }

        // 🔴 Validar cédula repetida
        for (String p : dao.cargarPersonas()) {
            String[] datos = p.split(";");
            if (datos.length >= 2 && datos[1].equals(cedula)) {
                System.out.println("Error: ya existe una persona con esa cédula");
                return;
            }
        }

        String tipoStr;

        switch (tipo) {
            case 1: tipoStr = "Regular"; break;
            case 2: tipoStr = "Estudiante"; break;
            case 3: tipoStr = "AdultoMayor"; break;
            default:
                System.out.println("Error: tipo inválido");
                return;
        }

        dao.guardarPersona("PASAJERO", cedula, nombre, tipoStr);

        System.out.println("Pasajero registrado correctamente");
    }

    public void mostrarPersonas() {
        System.out.println("\n--- LISTA DE PERSONAS ---");

        if (dao.cargarPersonas().isEmpty()) {
            System.out.println("No hay personas registradas");
            return;
        }

        for (String p : dao.cargarPersonas()) {
            System.out.println(p);
        }
    }
}