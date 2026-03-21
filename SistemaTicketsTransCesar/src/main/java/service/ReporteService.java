/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Personal
 */

import model.Ticket;
import java.util.List;

public class ReporteService {
    private List<Ticket> tickets;

    public ReporteService(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void listarTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No hay tickets registrados.");
            return;
        }
        System.out.println("\n=== LISTA DE TICKETS ===");
        for (Ticket t : tickets) {
            System.out.println("Vehículo: " + t.getVehiculo().getPlaca() +
                               " | Pasajero: " + t.getPasajero().getNombre() +
                               " | Tipo: " + t.getPasajero().getTipo() +
                               " | Precio: " + t.getPrecio());
        }
    }

    public void totalRecaudado() {
        if (tickets.isEmpty()) {
            System.out.println("No hay tickets para calcular el total.");
            return;
        }
        double total = tickets.stream().mapToDouble(Ticket::getPrecio).sum();
        System.out.println("Total recaudado: $" + total);
    }

    public void pasajerosPorTipo() {
        if (tickets.isEmpty()) {
            System.out.println("No hay tickets para calcular pasajeros por tipo.");
            return;
        }
        long regulares = tickets.stream().filter(t -> t.getPasajero().getTipo() == 1).count();
        long estudiantes = tickets.stream().filter(t -> t.getPasajero().getTipo() == 2).count();
        long adultos = tickets.stream().filter(t -> t.getPasajero().getTipo() == 3).count();

        System.out.println("Pasajeros por tipo:");
        System.out.println("Regulares: " + regulares);
        System.out.println("Estudiantes: " + estudiantes);
        System.out.println("Adultos mayores: " + adultos);
    }

    public void vehiculoMasVentas() {
        if (tickets.isEmpty()) {
            System.out.println("No hay tickets para calcular vehículo con más ventas.");
            return;
        }
        String placa = tickets.stream()
            .map(t -> t.getVehiculo().getPlaca())
            .reduce((a, b) -> a.equals(b) ? a : b).orElse("N/A");
        System.out.println("Vehículo con más ventas: " + placa);
    }
}