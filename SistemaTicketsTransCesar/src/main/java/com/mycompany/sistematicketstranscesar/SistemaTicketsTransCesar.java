/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistematicketstranscesar;

/**
 *
 * @author Personal
 */

import model.*;
import service.*;

public class SistemaTicketsTransCesar {

    public static void main(String[] args) {
        // Crear servicios
        VehiculoService vehiculoService = new VehiculoService();
        PersonaService personaService = new PersonaService();
        TicketService ticketService = new TicketService();
        ReporteService reporteService = new ReporteService();

        // Registrar un vehículo
        Vehiculo v1 = new Vehiculo("ABC123", "Toyota Corolla");
        vehiculoService.registrarVehiculo(v1);

        // Registrar un conductor
        Conductor c1 = new Conductor("Juan Pérez", "123456789", "LIC-987");
        personaService.registrarConductor(c1);

        // Registrar un pasajero
        Pasajero p1 = new Pasajero("María López", "987654321", "VIP");
        personaService.registrarPasajero(p1);

        // Vender un ticket
        Ticket t1 = new Ticket(v1, p1, 50000);
        ticketService.registrarTicket(t1);

        // Generar reporte
        reporteService.generarReporte(ticketService.getTickets());
    }
}

