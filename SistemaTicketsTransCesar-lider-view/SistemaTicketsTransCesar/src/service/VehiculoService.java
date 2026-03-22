package com.mycompany.sistematicketstranscesar.service;

import com.mycompany.sistematicketstranscesar.dao.VehiculoDAO;

public class VehiculoService {

    // Instancia del DAO
    private VehiculoDAO dao = new VehiculoDAO();

    // Método para registrar vehículo (GUARDA en archivo)
    public void registrarVehiculo(String tipo, String placa, String ruta) {

        if (placa.isEmpty() || ruta.isEmpty()) {
            System.out.println("Error: datos incompletos");
            return;
        }

        dao.guardarVehiculo(tipo, placa, ruta);

        System.out.println("Vehículo registrado y guardado correctamente");
    }

    // Método para mostrar vehículos (LEE del archivo)
    public void mostrarVehiculos() {

        System.out.println("\n--- LISTA DE VEHICULOS ---");

        for (String v : dao.cargarVehiculos()) {
            System.out.println(v);
        }
    }
}