package com.mycompany.sistematicketstranscesar.service;

import com.mycompany.sistematicketstranscesar.dao.VehiculoDAO;

public class VehiculoService {

    // Instancia del DAO
    private VehiculoDAO dao = new VehiculoDAO();

    // Método para registrar vehículo (GUARDA en archivo)
    public void registrarVehiculo(String tipo, String placa, String ruta) {

        // 🔴 Validaciones básicas
        if (tipo == null || tipo.isEmpty()) {
            System.out.println("Error: tipo inválido");
            return;
        }

        if (placa == null || placa.isEmpty()) {
            System.out.println("Error: placa vacía");
            return;
        }

        if (ruta == null || ruta.isEmpty()) {
            System.out.println("Error: ruta vacía");
            return;
        }

        // 🔴 Validación formato placa (ABC123)
        if (!placa.matches("[A-Z]{3}[0-9]{3}")) {
            System.out.println("Error: la placa debe tener formato ABC123");
            return;
        }

        // 🔴 Validar placa repetida
        for (String v : dao.cargarVehiculos()) {
            String[] datos = v.split(";");
            if (datos[1].equalsIgnoreCase(placa)) {
                System.out.println("Error: ya existe un vehículo con esa placa");
                return;
            }
        }

        // ✅ Guardar si todo está bien
        dao.guardarVehiculo(tipo, placa, ruta);

        System.out.println("Vehículo registrado correctamente");
    }

    // Método para mostrar vehículos (LEE del archivo)
    public void mostrarVehiculos() {

        System.out.println("\n--- LISTA DE VEHICULOS ---");

        for (String v : dao.cargarVehiculos()) {
            System.out.println(v);
        }
    }
}