/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class Reserva {
   private int idReserva;
   private LocalDate fechaEntrada;
   private LocalDate fechaSalida;
   private ArrayList<Huesped> listaHuesped = new ArrayList<>();
   private ArrayList<Habitacion> listaHabitacion = new ArrayList<>();

    public Reserva(int idReserva, LocalDate fechaEntrada, LocalDate fechaSalida) {
        setFechaEntrada(fechaEntrada);
        setFechaSalida(fechaSalida);
        setIdReserva(idReserva);
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public ArrayList<Huesped> getListaHuesped() {
        return listaHuesped;
    }

    public void setListaHuesped(ArrayList<Huesped> listaHuesped) {
        this.listaHuesped = listaHuesped;
    }

    public ArrayList<Habitacion> getListaHabitacion() {
        return listaHabitacion;
    }

    public void setListaHabitacion(ArrayList<Habitacion> listaHabitacion) {
        this.listaHabitacion = listaHabitacion;
    }

    
}
