/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistematicketstranscesar.model;

/**
 *
 * @author Personal
 */

public class Conductor {
    private String nombre;
    private String cedula;
    private String licencia;
    private String categoria;

    public Conductor(String nombre, String cedula, String licencia, String categoria) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.licencia = licencia;
        this.categoria = categoria;
    }

    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public String getLicencia() { return licencia; }
    public String getCategoria() { return categoria; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public void setLicencia(String licencia) { this.licencia = licencia; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
