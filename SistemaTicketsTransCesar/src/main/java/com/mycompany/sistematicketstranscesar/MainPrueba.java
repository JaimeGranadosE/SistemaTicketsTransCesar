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

public class MainPrueba {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        VehiculoService vehiculoService = new VehiculoService();
        PersonaService personaService = new PersonaService();
        TicketService ticketService = new TicketService(
            personaService.getPasajeros(), vehiculoService.getVehiculos()
        );
        ReporteService reporteService = new ReporteService(ticketService.getTickets());

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
                    System.out.print("Ruta: ");
                    String ruta = sc.nextLine();
                    vehiculoService.registrarVehiculo("Bus", placa, ruta);
                    break;

                case 2:
                    System.out.print("Nombre: ");
                    String nombreP = sc.nextLine();
                    System.out.print("Cédula: ");
                    String cedulaP = sc.nextLine();
                    System.out.print("Tipo (1-Regular, 2-Estudiante, 3-Adulto Mayor): ");
                    int tipoNum = sc.nextInt();
                    sc.nextLine();
                    personaService.registrarPasajero(cedulaP, nombreP, tipoNum);
                    break;

                case 3:
                    System.out.print("Nombre: ");
                    String nombreC = sc.nextLine();
                    System.out.print("Cédula: ");
                    String cedulaC = sc.nextLine();
                    System.out.print("Licencia: ");
                    String licencia = sc.nextLine();
                    personaService.registrarConductor(cedulaC, nombreC, licencia, "Categoria A");
                    break;

                case 4:
                    if (vehiculoService.getVehiculos().isEmpty() || personaService.getPasajeros().isEmpty()) {
                        System.out.println("Debe registrar al menos un vehículo y un pasajero antes de vender tickets.");
                    } else {
                        System.out.println("Seleccione vehículo:");
                        for (int i = 0; i < vehiculoService.getVehiculos().size(); i++) {
                            System.out.println(i + ". " + vehiculoService.getVehiculos().get(i).getPlaca());
                        }
                        int idxVehiculo = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Seleccione pasajero:");
                        for (int i = 0; i < personaService.getPasajeros().size(); i++) {
                            System.out.println(i + ". " + personaService.getPasajeros().get(i).getNombre());
                        }
                        int idxPasajero = sc.nextInt();
                        sc.nextLine();

                        String cedulaSel = personaService.getPasajeros().get(idxPasajero).getCedula();
                        String placaSel = vehiculoService.getVehiculos().get(idxVehiculo).getPlaca();

                        ticketService.venderTicket(cedulaSel, placaSel, "Origen", "Destino");
                    }
                    break;

                case 5:
                    reporteService.listarTickets();
                    reporteService.totalRecaudado();
                    reporteService.pasajerosPorTipo();
                    reporteService.vehiculoMasVentas();
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