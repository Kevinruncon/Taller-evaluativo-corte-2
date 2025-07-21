/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import Exceptiones.HabitacionException;
import daos.DaoHabitacion;
import dto.DtoHabitacion;
import Exceptiones.IdentificadorException;
import java.util.ArrayList;
/**
 *
 * @author Kevin
 */
public class ControladorHabitacion {
    
   private DaoHabitacion daoHabitacion;

    public ControladorHabitacion() {
        this.daoHabitacion = new DaoHabitacion();
    }
    
 

    public boolean guardarHabitacion(DtoHabitacion habitacion) {
        if (habitacion == null) {
            throw new HabitacionException("La habitación no puede ser nula.");
        }

        if (habitacion.getNumero() <= 0) {
            throw new IdentificadorException("El número de la habitación debe ser mayor a cero.");
        }

        if (habitacion.getTipo() == null || habitacion.getTipo().isEmpty() ) {
            throw new HabitacionException("El tipo de habitación no puede estar vacío.");
        }

        if (habitacion.getCapacidad() <= 0) {
            throw new HabitacionException("La capacidad de la habitación debe ser mayor a cero.");
        }

        if (habitacion.getEstado() == null || habitacion.getEstado().isEmpty()) {
            throw new HabitacionException("El estado de la habitación no puede estar vacío.");
        }
        DtoHabitacion buscar = daoHabitacion.buscarHabitacion(habitacion.getNumero());
        if(buscar== null){
        return daoHabitacion.guardarHabitacion(habitacion);
        }
        return false;
    }

    public DtoHabitacion buscarHabitacion(int numero) {
        if (numero <= 0) {
            throw new IdentificadorException("El número de habitación debe ser mayor a cero.");
        }

        DtoHabitacion hab = daoHabitacion.buscarHabitacion(numero);
        if (hab == null) {
            throw new HabitacionException("No se encontró la habitación con número: " + numero);
        }

        return hab;
    }

    public boolean actualizarEstado(int numero, String nuevoEstado) {
        if (numero <= 0) {
            throw new IdentificadorException("El número de habitación no es válido.");
        }

        if (nuevoEstado == null || nuevoEstado.isEmpty()) {
            throw new HabitacionException("Debe especificar un estado válido.");
        }

        return daoHabitacion.actualizarEstado(numero, nuevoEstado);
    }

    public boolean eliminarHabitacion(int numero) {
        if (numero <= 0) {
            throw new IdentificadorException("El número de habitación no es válido.");
        }

        DtoHabitacion hab = daoHabitacion.buscarHabitacion(numero);
        if (hab == null) {
            throw new HabitacionException("No existe la habitación a eliminar con número: " + numero);
        }

        return daoHabitacion.eliminarHabitacion(numero);
    }

    public ArrayList<DtoHabitacion> getListaHabitaciones() {
        return daoHabitacion.getListaHabitaciones();
   
    }
 }
