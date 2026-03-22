package com.mycompany.sistematicketstranscesar.dao;

import java.io.*;
import java.util.*;

public class PersonaDAO {

    private final String archivo = "personas.txt";

    public void guardarPersona(String tipoPersona, String cedula, String nombre, String extra) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {

            bw.write(tipoPersona + ";" + cedula + ";" + nombre + ";" + extra);
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error al guardar persona");
        }
    }

    public List<String> cargarPersonas() {
        List<String> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }

        } catch (IOException e) {
            System.out.println("No hay personas registradas");
        }

        return lista;
    }
}