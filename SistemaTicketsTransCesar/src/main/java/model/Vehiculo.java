/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Personal
 */

public class Vehiculo {
    private String tipo;
    private String placa;
    private String ruta;

    public Vehiculo(String tipo, String placa, String ruta) {
        this.tipo = tipo;
        this.placa = placa;
        this.ruta = ruta;
    }

    public String getTipo() { return tipo; }
    public String getPlaca() { return placa; }
    public String getRuta() { return ruta; }

    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setPlaca(String placa) { this.placa = placa; }
    public void setRuta(String ruta) { this.ruta = ruta; }
}
