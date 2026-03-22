package com.mycompany.sistematicketstranscesar.service;

import com.mycompany.sistematicketstranscesar.dao.TicketDAO;
import com.mycompany.sistematicketstranscesar.dao.PersonaDAO;
import com.mycompany.sistematicketstranscesar.dao.VehiculoDAO;

public class TicketService {

    private TicketDAO dao = new TicketDAO();

    public void venderTicket(String cedula, String placa, String origen, String destino) {

        // 🔴 Validaciones básicas
        if (cedula == null || cedula.isEmpty()) {
            System.out.println("Error: cédula vacía");
            return;
        }

        if (placa == null || placa.isEmpty()) {
            System.out.println("Error: placa vacía");
            return;
        }

        if (origen == null || origen.isEmpty()) {
            System.out.println("Error: origen vacío");
            return;
        }

        if (destino == null || destino.isEmpty()) {
            System.out.println("Error: destino vacío");
            return;
        }

        // 🔴 Validar formato placa (ABC123)
        if (!placa.matches("[A-Z]{3}[0-9]{3}")) {
            System.out.println("Error: formato de placa inválido (ABC123)");
            return;
        }

        // 🔴 Validar que origen y destino no sean iguales
        if (origen.equalsIgnoreCase(destino)) {
            System.out.println("Error: origen y destino no pueden ser iguales");
            return;
        }

        boolean pasajeroExiste = false;
        boolean vehiculoExiste = false;

        PersonaDAO personaDAO = new PersonaDAO();
        VehiculoDAO vehiculoDAO = new VehiculoDAO();

        // 🔴 Validar pasajero existente
        for (String p : personaDAO.cargarPersonas()) {
            String[] datos = p.split(";");
            if (datos[0].equals("PASAJERO") && datos[1].equals(cedula)) {
                pasajeroExiste = true;
                break;
            }
        }

        // 🔴 Validar vehículo existente
        for (String v : vehiculoDAO.cargarVehiculos()) {
            String[] datos = v.split(";");
            if (datos[1].equalsIgnoreCase(placa)) {
                vehiculoExiste = true;
                break;
            }
        }

        if (!pasajeroExiste) {
            System.out.println("Error: pasajero no registrado");
            return;
        }

        if (!vehiculoExiste) {
            System.out.println("Error: vehículo no registrado");
            return;
        }

        // ✅ Guardar ticket
        dao.guardarTicket(cedula, placa, origen, destino);

        System.out.println("Ticket vendido correctamente");
    }

    public void mostrarTickets() {
        System.out.println("\n--- LISTA DE TICKETS ---");

        for (String t : dao.cargarTickets()) {
            System.out.println(t);
        }
    }
}