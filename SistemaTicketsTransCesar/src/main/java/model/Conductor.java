/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Personal
 */

public class Conductor extends Persona {
    private String licencia;

    public Conductor(String nombre, String cedula, String licencia) {
        super(nombre, cedula);
        this.licencia = licencia;
    }

    public String getLicencia() { return licencia; }
}
