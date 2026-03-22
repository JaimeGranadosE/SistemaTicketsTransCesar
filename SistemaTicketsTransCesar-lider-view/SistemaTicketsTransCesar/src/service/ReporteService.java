package com.mycompany.sistematicketstranscesar.service;

import com.mycompany.sistematicketstranscesar.dao.TicketDAO;
import com.mycompany.sistematicketstranscesar.dao.PersonaDAO;
import java.util.*;

public class ReporteService {

    private TicketDAO ticketDAO = new TicketDAO();
    private PersonaDAO personaDAO = new PersonaDAO();

    public void listarTickets() {
        System.out.println("\n--- LISTA DE TICKETS ---");

        for (String t : ticketDAO.cargarTickets()) {
            System.out.println(t);
        }
    }

    public void totalRecaudado() {

        int total = 0;
        int precio = 5000; // puedes cambiar el valor si quieres

        for (String t : ticketDAO.cargarTickets()) {
            total += precio;
        }

        System.out.println("Total recaudado: $" + total);
    }

    public void pasajerosPorTipo() {

        int regular = 0, estudiante = 0, adulto = 0;

        for (String p : personaDAO.cargarPersonas()) {

            String[] datos = p.split(";");

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

        Map<String, Integer> conteo = new HashMap<>();

        for (String t : ticketDAO.cargarTickets()) {

            String[] datos = t.split(";");
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