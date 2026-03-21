/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Personal
 */

public class Pasajero extends Persona {
    private String tipo;

    public Pasajero(String nombre, String cedula, String tipo) {
        super(nombre, cedula);
        this.tipo = tipo;
    }

    public String getTipo() { return tipo; }
}
