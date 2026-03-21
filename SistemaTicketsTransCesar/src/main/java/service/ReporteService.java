/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Personal
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Ticket;
import model.Vehiculo;
import model.Pasajero;

public class ReporteService {

    public void generarReporte(List<Ticket> tickets) {
        double total = 0;
        Map<String, Integer> pasajerosPorTipo = new HashMap<>();
        Map<Vehiculo, Integer> ventasPorVehiculo = new HashMap<>();

        // Recorrer tickets
        for (Ticket t : tickets) {
            total += t.getPrecio();

            // Contar pasajeros por tipo
            Pasajero p = t.getPasajero();
            pasajerosPorTipo.put(p.getTipo(),
                pasajerosPorTipo.getOrDefault(p.getTipo(), 0) + 1);

            // Contar ventas por vehículo
            Vehiculo v = t.getVehiculo();
            ventasPorVehiculo.put(v,
                ventasPorVehiculo.getOrDefault(v, 0) + 1);
        }

        // Mostrar tickets
        System.out.println("=== LISTA DE TICKETS ===");
        for (Ticket t : tickets) {
            System.out.println("Vehículo: " + t.getVehiculo().getPlaca() +
                               " | Pasajero: " + t.getPasajero().getNombre() +
                               " | Precio: " + t.getPrecio());
        }

        // Total recaudado
        System.out.println("\nTotal recaudado: " + total);
        System.out.println("Cantidad de tickets vendidos: " + tickets.size());

        // Pasajeros por tipo
        System.out.println("\n=== Pasajeros por tipo ===");
        for (String tipo : pasajerosPorTipo.keySet()) {
            System.out.println(tipo + ": " + pasajerosPorTipo.get(tipo));
        }

        // Vehículo con más ventas
        Vehiculo masVendido = null;
        int maxVentas = 0;
        for (Map.Entry<Vehiculo, Integer> entry : ventasPorVehiculo.entrySet()) {
            if (entry.getValue() > maxVentas) {
                maxVentas = entry.getValue();
                masVendido = entry.getKey();
            }
        }

        if (masVendido != null) {
            System.out.println("\nVehículo con más ventas: " +
                               masVendido.getPlaca() +
                               " (" + maxVentas + " tickets)");
        }
    }
}
