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
import model.Vehiculo;

public class VehiculoService {
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public void registrarVehiculo(Vehiculo v) {
        vehiculos.add(v);
        System.out.println("Vehículo registrado: " + v.getPlaca());
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    public void registrarVehiculo(String tipo, String placa, String ruta) {
        Vehiculo v = new Vehiculo(placa, tipo + " - " + ruta);
        vehiculos.add(v);
        System.out.println("Vehículo registrado: " + v.getPlaca() + " (" + tipo + ")");
    }
}
