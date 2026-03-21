/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Personal
 */

import model.Vehiculo;
import java.util.ArrayList;
import java.util.List;

public class VehiculoService {
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public void registrarVehiculo(String tipo, String placa, String ruta) {
        if (placa == null || placa.isEmpty()) {
            System.out.println("Error: la placa no puede estar vacía.");
            return;
        }
        boolean existe = vehiculos.stream().anyMatch(v -> v.getPlaca().equalsIgnoreCase(placa));
        if (existe) {
            System.out.println("Error: ya existe un vehículo con esa placa.");
            return;
        }
        Vehiculo v = new Vehiculo(tipo, placa, ruta);
        vehiculos.add(v);
        System.out.println("Vehículo registrado: " + placa);
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}