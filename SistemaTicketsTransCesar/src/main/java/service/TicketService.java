/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Personal
 */

import java.util.ArrayList;
import java.util.List;
import model.Ticket;
import model.Pasajero;
import model.Vehiculo;

public class TicketService {
    private List<Ticket> tickets = new ArrayList<>();
    private List<Pasajero> pasajeros;
    private List<Vehiculo> vehiculos;

    public TicketService(List<Pasajero> pasajeros, List<Vehiculo> vehiculos) {
        this.pasajeros = pasajeros;
        this.vehiculos = vehiculos;
    }

    public void registrarTicket(Ticket t) {
        tickets.add(t);
        System.out.println("Ticket registrado: " + t.getPasajero().getNombre());
    }

    public void venderTicket(String cedula, String placa, String origen, String destino) {
        Pasajero pasajero = pasajeros.stream()
            .filter(p -> p.getCedula().equals(cedula))
            .findFirst()
            .orElse(null);

        Vehiculo vehiculo = vehiculos.stream()
            .filter(v -> v.getPlaca().equals(placa))
            .findFirst()
            .orElse(null);

        if (pasajero != null && vehiculo != null) {
            Ticket t = new Ticket(vehiculo, pasajero, 5000);
            tickets.add(t);
            System.out.println("Ticket vendido: " + pasajero.getNombre() +
                               " en vehículo " + vehiculo.getPlaca() +
                               " de " + origen + " a " + destino);
        } else {
            System.out.println("Error: pasajero o vehículo no encontrado.");
        }
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}