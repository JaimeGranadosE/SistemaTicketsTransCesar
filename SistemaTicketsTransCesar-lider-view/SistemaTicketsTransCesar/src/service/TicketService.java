package com.mycompany.sistematicketstranscesar.service;

import com.mycompany.sistematicketstranscesar.dao.TicketDAO;

public class TicketService {

    private TicketDAO dao = new TicketDAO();

    public void venderTicket(String cedula, String placa, String origen, String destino) {

        if (cedula.isEmpty() || placa.isEmpty()) {
            System.out.println("Datos inválidos");
            return;
        }

        dao.guardarTicket(cedula, placa, origen, destino);

        System.out.println("Ticket vendido y guardado");
    }

    public void mostrarTickets() {
        System.out.println("\n--- LISTA DE TICKETS ---");

        for (String t : dao.cargarTickets()) {
            System.out.println(t);
        }
    }
}