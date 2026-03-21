/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Personal
 */
public class Pasajero {
    private String cedula;
    private String nombre;
    private int tipo;

    public Pasajero(String cedula, String nombre, int tipo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public int getTipo() { return tipo; }

    public void setCedula(String cedula) { this.cedula = cedula; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTipo(int tipo) { this.tipo = tipo; }
}