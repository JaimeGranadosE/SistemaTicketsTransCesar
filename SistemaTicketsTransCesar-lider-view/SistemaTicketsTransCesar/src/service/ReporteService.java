package com.mycompany.sistematicketstranscesar.service;

import com.mycompany.sistematicketstranscesar.dao.TicketDAO;
import com.mycompany.sistematicketstranscesar.dao.PersonaDAO;
import java.util.*;

public class ReporteService {

    private TicketDAO ticketDAO = new TicketDAO();
    private PersonaDAO personaDAO = new PersonaDAO();

    public void listarTickets() {
        System.out.println("\n--- LISTA DE TICKETS ---");

        List<String> tickets = ticketDAO.cargarTickets();

        if (tickets.isEmpty()) {
            System.out.println("No hay tickets registrados");
            return;
        }

        for (String t : tickets) {
            System.out.println(t);
        }
    }

    public void totalRecaudado() {

        List<String> tickets = ticketDAO.cargarTickets();

        if (tickets.isEmpty()) {
            System.out.println("No hay tickets registrados");
            return;
        }

        int total = 0;
        int precio = 5000;

        for (String t : tickets) {
            total += precio;
        }

        System.out.println("Total recaudado: $" + total);
    }

    public void pasajerosPorTipo() {

        List<String> personas = personaDAO.cargarPersonas();

        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas");
            return;
        }

        int regular = 0, estudiante = 0, adulto = 0;

        for (String p : personas) {

            String[] datos = p.split(";");

            // 🔴 Validar estructura correcta
            if (datos.length < 4) continue;

            if (datos[0].equals("PASAJERO")) {

                switch (datos[3]) {
                    case "Regular": regular++; break;
                    case "Estudiante": estudiante++; break;
                    case "AdultoMayor": adulto++; break;
                }
            }
        }

        System.out.println("Regulares: " + regular);
        System.out.println("Estudiantes: " + estudiante);
        System.out.println("Adulto Mayor: " + adulto);
    }

    public void vehiculoMasVentas() {

        List<String> tickets = ticketDAO.cargarTickets();

        if (tickets.isEmpty()) {
            System.out.println("No hay ventas registradas aún");
            return;
        }

        Map<String, Integer> conteo = new HashMap<>();

        for (String t : tickets) {

            String[] datos = t.split(";");

            // 🔴 Validar estructura
            if (datos.length < 2) continue;

            String placa = datos[1];

            conteo.put(placa, conteo.getOrDefault(placa, 0) + 1);
        }

        String mejorVehiculo = "";
        int max = 0;

        for (String placa : conteo.keySet()) {
            if (conteo.get(placa) > max) {
                max = conteo.get(placa);
                mejorVehiculo = placa;
            }
        }

        if (max == 0) {
            System.out.println("No hay ventas registradas aún");
        } else {
            System.out.println("Vehículo con más ventas: " + mejorVehiculo + " (" + max + " tickets)");
        }
    }
}