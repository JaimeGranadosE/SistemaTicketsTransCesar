package com.mycompany.sistematicketstranscesar.dao;

import java.io.*;
import java.util.*;

public class VehiculoDAO {

    private final String archivo = "vehiculos.txt";

    public void guardarVehiculo(String tipo, String placa, String ruta) {
        try (FileWriter fw = new FileWriter(archivo, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(tipo + ";" + placa + ";" + ruta);
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error al guardar vehículo");
        }
    }

    public List<String> cargarVehiculos() {
        List<String> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }

        } catch (IOException e) {
            System.out.println("No hay datos aún");
        }

        return lista;
    }
}