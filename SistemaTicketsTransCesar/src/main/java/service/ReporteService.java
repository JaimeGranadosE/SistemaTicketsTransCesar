/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Personal
 */

import java.util.List;
import model.Ticket;
import model.Pasajero;
import model.Vehiculo;

public class ReporteService {
    private List<Ticket> tickets;

    public ReporteService(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void listarTickets() {
        System.out.println("\n=== LISTA DE TICKETS ===");
        for (Ticket t : tickets) {
            System.out.println("Vehículo: " + t.getVehiculo().getPlaca() +
                               " | Pasajero: " + t.getPasajero().getNombre() +
                               " | Tipo: " + t.getPasajero().getTipo() +
                               " | Precio: " + t.getPrecio());
        }
    }

    public void totalRecaudado() {
        double total = tickets.stream().mapToDouble(Ticket::getPrecio).sum();
        System.out.println("\nTotal recaudado: " + total);
    }

    public void pasajerosPorTipo() {
        long regulares = tickets.stream().filter(t -> t.getPasajero().getTipo().equals("Regular")).count();
        long estudiantes = tickets.stream().filter(t -> t.getPasajero().getTipo().equals("Estudiante")).count();
        long adultos = tickets.stream().filter(t -> t.getPasajero().getTipo().equals("Adulto Mayor")).count();

        System.out.println("\n=== Pasajeros por tipo ===");
        System.out.println("Regular: " + regulares);
        System.out.println("Estudiante: " + estudiantes);
        System.out.println("Adulto Mayor: " + adultos);
    }

    public void vehiculoMasVentas() {
        Vehiculo maxVehiculo = tickets.stream()
            .map(Ticket::getVehiculo)
            .distinct()
            .max((v1, v2) -> Long.compare(
                tickets.stream().filter(t -> t.getVehiculo().equals(v1)).count(),
                tickets.stream().filter(t -> t.getVehiculo().equals(v2)).count()
            ))
            .orElse(null);

        if (maxVehiculo != null) {
            long ventas = tickets.stream().filter(t -> t.getVehiculo().equals(maxVehiculo)).count();
            System.out.println("\nVehículo con más ventas: " + maxVehiculo.getPlaca() + " (" + ventas + " tickets)");
        } else {
            System.out.println("\nNo hay tickets registrados.");
        }
    }
}