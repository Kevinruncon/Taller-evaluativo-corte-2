/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import modelo.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class DtoReserva {
   private int idReserva;
   private LocalDate fechaEntrada;
   private LocalDate fechaSalida;
   private ArrayList<DtoHuesped> listaHuesped = new ArrayList<>();
   private ArrayList<DtoHabitacion> listaHabitacion = new ArrayList<>();

    public DtoReserva(int idReserva, String fechaEntrada, String fechaSalida) {
        setFechaEntrada(fechaEntrada);
        setFechaSalida(fechaSalida);
        setIdReserva(idReserva);
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        if(idReserva <= 0){
            throw new IllegalArgumentException("El ID de la reserva no puede ser negativo");
        }
        this.idReserva = idReserva;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaTexto) {
        try{
        this.fechaEntrada = LocalDate.parse(fechaTexto);
        }catch (DateTimeParseException e){
            throw new IllegalArgumentException("Formato de fecha invalido.");
        }
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        try{
        this.fechaSalida = LocalDate.parse(fechaSalida) ;
        }catch(DateTimeParseException e){
            throw new IllegalArgumentException("Formato de fecha invalido");
        }
    }

    public ArrayList<DtoHuesped> getListaHuesped() {
        return listaHuesped;
    }

    public void setListaHuesped(ArrayList<DtoHuesped> listaHuesped) {
        this.listaHuesped = listaHuesped;
    }

    public ArrayList<DtoHabitacion> getListaHabitacion() {
        return listaHabitacion;
    }

    public void setListaHabitacion(ArrayList<DtoHabitacion> listaHabitacion) {
        this.listaHabitacion = listaHabitacion;
    }

    
}
