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
import model.Vehiculo;
import model.Ticket;
import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private List<Ticket> tickets = new ArrayList<>();
    private List<Pasajero> pasajeros;
    private List<Vehiculo> vehiculos;

    public TicketService(List<Pasajero> pasajeros, List<Vehiculo> vehiculos) {
        this.pasajeros = pasajeros;
        this.vehiculos = vehiculos;
    }

    public void venderTicket(String cedulaPasajero, String placaVehiculo, String origen, String destino) {
        if (cedulaPasajero == null || placaVehiculo == null) {
            System.out.println("Error: datos inválidos para vender ticket.");
            return;
        }
        Pasajero pasajero = pasajeros.stream()
            .filter(p -> p.getCedula().equalsIgnoreCase(cedulaPasajero))
            .findFirst().orElse(null);
        Vehiculo vehiculo = vehiculos.stream()
            .filter(v -> v.getPlaca().equalsIgnoreCase(placaVehiculo))
            .findFirst().orElse(null);

        if (pasajero == null || vehiculo == null) {
            System.out.println("Error: pasajero o vehículo no encontrado.");
            return;
        }

        double precio = calcularPrecio(pasajero.getTipo());
        if (precio <= 0) {
            System.out.println("Error: precio inválido.");
            return;
        }

        Ticket t = new Ticket(vehiculo, pasajero, precio);
        tickets.add(t);
        System.out.println("Ticket vendido a " + pasajero.getNombre() + " por $" + precio);
    }

    private double calcularPrecio(int tipoPasajero) {
        switch (tipoPasajero) {
            case 1: return 10000; // Regular
            case 2: return 8000;  // Estudiante
            case 3: return 6000;  // Adulto Mayor
            default: return 0;
        }
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}