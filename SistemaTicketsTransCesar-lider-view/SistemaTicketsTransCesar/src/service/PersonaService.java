package com.mycompany.sistematicketstranscesar.service;

import com.mycompany.sistematicketstranscesar.dao.PersonaDAO;

public class PersonaService {

    private PersonaDAO dao = new PersonaDAO();

    public void registrarConductor(String cedula, String nombre, String licencia, String categoria) {

        if (cedula.isEmpty() || nombre.isEmpty()) {
            System.out.println("Datos inválidos");
            return;
        }

        dao.guardarPersona("CONDUCTOR", cedula, nombre, licencia + "-" + categoria);

        System.out.println("Conductor guardado correctamente");
    }

    public void registrarPasajero(String cedula, String nombre, int tipo) {

        String tipoStr;

        switch (tipo) {
            case 1: tipoStr = "Regular"; break;
            case 2: tipoStr = "Estudiante"; break;
            case 3: tipoStr = "AdultoMayor"; break;
            default:
                System.out.println("Tipo inválido");
                return;
        }

        dao.guardarPersona("PASAJERO", cedula, nombre, tipoStr);

        System.out.println("Pasajero guardado correctamente");
    }

    public void mostrarPersonas() {
        System.out.println("\n--- LISTA DE PERSONAS ---");

        for (String p : dao.cargarPersonas()) {
            System.out.println(p);
        }
    }
}