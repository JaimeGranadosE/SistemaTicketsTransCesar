package com.mycompany.sistematicketstranscesar.view;

import java.util.Scanner;
import com.mycompany.sistematicketstranscesar.service.*;

public class Menu {

    private final Scanner sc = new Scanner(System.in);

    private VehiculoService vehiculoService = new VehiculoService();
    private PersonaService personaService = new PersonaService();
    private TicketService ticketService = new TicketService();
    private ReporteService reporteService = new ReporteService();

    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n==============================");
            System.out.println("   SISTEMA TRANS CESAR");
            System.out.println("==============================");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Registrar conductor");
            System.out.println("3. Registrar pasajero");
            System.out.println("4. Vender ticket");
            System.out.println("5. Reportes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1: registrarVehiculo(); break;
                case 2: registrarConductor(); break;
                case 3: registrarPasajero(); break;
                case 4: venderTicket(); break;
                case 5: menuReportes(); break;
                case 6: System.out.println("Saliendo del sistema..."); break;
                default: System.out.println("Opción inválida");
            }
        } while(opcion != 6);
    }

    private void registrarVehiculo() {
        System.out.println("\n--- REGISTRO DE VEHÍCULO ---");
        System.out.println("1. Buseta");
        System.out.println("2. MicroBus");
        System.out.println("3. Bus");
        System.out.print("Seleccione tipo: ");

        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Placa: ");
        String placa = sc.nextLine();

        System.out.print("Ruta: ");
        String ruta = sc.nextLine();

        String tipoStr;
        switch (tipo) {
            case 1: tipoStr = "Buseta"; break;
            case 2: tipoStr = "MicroBus"; break;
            case 3: tipoStr = "Bus"; break;
            default:
                System.out.println("Tipo inválido");
                return;
        }

        vehiculoService.registrarVehiculo(tipoStr, placa, ruta);
    }

    private void registrarConductor() {
        System.out.println("\n--- REGISTRO DE CONDUCTOR ---");
        System.out.print("Cédula: ");
        String cedula = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Licencia: ");
        String licencia = sc.nextLine();
        System.out.print("Categoría (B1, B2, C1, C2): ");
        String categoria = sc.nextLine();

        personaService.registrarConductor(cedula, nombre, licencia, categoria);
    }

    private void registrarPasajero() {
        System.out.println("\n--- REGISTRO DE PASAJERO ---");
        System.out.print("Cédula: ");
        String cedula = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Tipo de pasajero:");
        System.out.println("1. Regular");
        System.out.println("2. Estudiante");
        System.out.println("3. Adulto Mayor");
        System.out.print("Seleccione tipo: ");

        int tipo = sc.nextInt();
        sc.nextLine();

        personaService.registrarPasajero(cedula, nombre, tipo);
    }

    private void venderTicket() {
        System.out.println("\n--- VENTA DE TICKET ---");
        System.out.print("Cédula del pasajero: ");
        String cedula = sc.nextLine();
        System.out.print("Placa del vehículo: ");
        String placa = sc.nextLine();
        System.out.print("Origen: ");
        String origen = sc.nextLine();
        System.out.print("Destino: ");
        String destino = sc.nextLine();

        ticketService.venderTicket(cedula, placa, origen, destino);
    }

    private void menuReportes() {
        int opcion;
        do {
            System.out.println("\n--- REPORTES ---");
            System.out.println("1. Listar tickets");
            System.out.println("2. Total recaudado");
            System.out.println("3. Pasajeros por tipo");
            System.out.println("4. Vehículo con más ventas");
            System.out.println("5. Volver");
            System.out.print("Seleccione: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1: reporteService.listarTickets(); break;
                case 2: reporteService.totalRecaudado(); break;
                case 3: reporteService.pasajerosPorTipo(); break;
                case 4: reporteService.vehiculoMasVentas(); break;
                case 5: break;
                default: System.out.println("Opción inválida");
            }
        } while(opcion != 5);
    }
}
