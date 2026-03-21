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
import model.Vehiculo;

public class ReporteService {
    public void generarReporte(List<Ticket> tickets) {
        double total = 0;
        Vehiculo masVendido = null;
        int maxVentas = 0;

        for (Ticket t : tickets) {
            total += t.getPrecio();
        }

        System.out.println("Total recaudado: " + total);
        System.out.println("Cantidad de tickets vendidos: " + tickets.size());
    }
}
