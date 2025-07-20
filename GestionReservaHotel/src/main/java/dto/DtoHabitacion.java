/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import modelo.*;

/**
 *
 * @author Kevin
 */
public class DtoHabitacion {
    private int numero ;
    private String tipo; 
    private int capacidad ;
    private String estado;

    public DtoHabitacion(int numero, String tipo, int capacidad, String estado) {
        setNumero(numero);
        setTipo(tipo);
        setCapacidad(capacidad);
        setEstado(estado);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if(numero <= 0){
            throw new IllegalArgumentException("El numero de habitacion no puede ser negativo");
        }
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if(tipo == null || tipo.isBlank()){
            throw new IllegalArgumentException("El tipo no puede estar vacio");
        }
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0){
            throw new IllegalArgumentException("La capacidad no puede ser menor a cero");
        }
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if(estado == null || estado.isBlank()){
            throw new IllegalArgumentException("El estado no puede estar vacio");
        }
        this.estado = estado;
    }
    
}
