package view;

import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);

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
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    registrarConductor();
                    break;
                case 3:
                    registrarPasajero();
                    break;
                case 4:
                    venderTicket();
                    break;
                case 5:
                    menuReportes();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida");
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

        System.out.println("Vehículo registrado (pendiente integración)");
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

        System.out.println("Conductor registrado (pendiente integración)");
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

        System.out.println("Pasajero registrado (pendiente integración)");
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

        System.out.println("Ticket generado (pendiente integración)");
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
                case 1:
                    System.out.println("Listado de tickets (pendiente)");
                    break;
                case 2:
                    System.out.println("Total recaudado (pendiente)");
                    break;
                case 3:
                    System.out.println("Pasajeros por tipo (pendiente)");
                    break;
                case 4:
                    System.out.println("Vehículo con más ventas (pendiente)");
                    break;
            }

        } while(opcion != 5);
    }
}