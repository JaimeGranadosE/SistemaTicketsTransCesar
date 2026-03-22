package com.mycompany.sistematicketstranscesar.dao;

import java.io.*;
import java.util.*;

public class TicketDAO {

    private final String archivo = "tickets.txt";

    public void guardarTicket(String cedula, String placa, String origen, String destino) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {

            bw.write(cedula + ";" + placa + ";" + origen + ";" + destino);
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error al guardar ticket");
        }
    }

    public List<String> cargarTickets() {
        List<String> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }

        } catch (IOException e) {
            System.out.println("No hay tickets registrados");
        }

        return lista;
    }
}