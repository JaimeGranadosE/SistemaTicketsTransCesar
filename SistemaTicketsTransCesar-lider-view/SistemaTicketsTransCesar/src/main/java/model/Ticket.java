/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistematicketstranscesar.model;

/**
 *
 * @author Personal
 */

public class Ticket {
    private Vehiculo vehiculo;
    private Pasajero pasajero;
    private double precio;

    public Ticket(Vehiculo vehiculo, Pasajero pasajero, double precio) {
        this.vehiculo = vehiculo;
        this.pasajero = pasajero;
        this.precio = precio;
    }

    public Vehiculo getVehiculo() { return vehiculo; }
    public Pasajero getPasajero() { return pasajero; }
    public double getPrecio() { return precio; }

    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
    public void setPasajero(Pasajero pasajero) { this.pasajero = pasajero; }
    public void setPrecio(double precio) { this.precio = precio; }
}
