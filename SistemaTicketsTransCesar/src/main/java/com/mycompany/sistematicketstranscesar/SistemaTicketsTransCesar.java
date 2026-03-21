/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistematicketstranscesar;

/**
 *
 * @author Personal
 */

import java.util.Scanner;
import model.*;
import service.*;

public class SistemaTicketsTransCesar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        VehiculoService vehiculoService = new VehiculoService();
        PersonaService personaService = new PersonaService();
        TicketService ticketService = new TicketService();
        ReporteService reporteService = new ReporteService();

        int opcion;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Registrar pasajero");
            System.out.println("3. Registrar conductor");
            System.out.println("4. Vender ticket");
            System.out.println("5. Generar reporte");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    Vehiculo v = new Vehiculo(placa, modelo);
                    vehiculoService.registrarVehiculo(v);
                    break;

                case 2:
                    System.out.print("Nombre: ");
                    String nombreP = sc.nextLine();
                    System.out.print("Cédula: ");
                    String cedulaP = sc.nextLine();
                    System.out.print("Tipo (VIP/Regular): ");
                    String tipo = sc.nextLine();
                    Pasajero p = new Pasajero(nombreP, cedulaP, tipo);
                    personaService.registrarPasajero(p);
                    break;

                case 3:
                    System.out.print("Nombre: ");
                    String nombreC = sc.nextLine();
                    System.out.print("Cédula: ");
                    String cedulaC = sc.nextLine();
                    System.out.print("Licencia: ");
                    String licencia = sc.nextLine();
                    Conductor c = new Conductor(nombreC, cedulaC, licencia);
                    personaService.registrarConductor(c);
                    break;

                case 4:
                    if (vehiculoService.getVehiculos().isEmpty() || personaService.getPasajeros().isEmpty()) {
                        System.out.println("Debe registrar al menos un vehículo y un pasajero antes de vender tickets.");
                    } else {
                        Vehiculo vehiculoTicket = vehiculoService.getVehiculos().get(0); // ejemplo: primer vehículo
                        Pasajero pasajeroTicket = personaService.getPasajeros().get(0); // ejemplo: primer pasajero
                        System.out.print("Precio del ticket: ");
                        double precio = sc.nextDouble();
                        sc.nextLine();
                        Ticket t = new Ticket(vehiculoTicket, pasajeroTicket, precio);
                        ticketService.registrarTicket(t);
                    }
                    break;

                case 5:
                    reporteService.generarReporte(ticketService.getTickets());
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
