/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dto.DtoHabitacion;
import dto.DtoReserva;
import daos.DaoHabitacion;
import daos.DaoReserva;
import Exceptiones.ReservaExecption;
import Exceptiones.IdentificadorException;
import Exceptiones.HabitacionException;

/**
 *
 * @author Kevin
 */
public class ControladorReserva {

    private DaoReserva daoReserva;
    private DaoHabitacion daoHabitacion;

    public ControladorReserva() {
        this.daoReserva = new DaoReserva();
        this.daoHabitacion = new DaoHabitacion();
    }

    public boolean guardarReserva(DtoReserva nuevaReserva) {
        if (nuevaReserva == null) {
            throw new ReservaExecption("La reserva no puede ser nula");
        }
        if (nuevaReserva.getIdReserva() <= 0) {
            throw new IdentificadorException("El Id de la reserva no puede ser menor a cero.");
        }
        if (nuevaReserva.getFechaEntrada() == null
                || nuevaReserva.getFechaSalida() == null) {
            throw new ReservaExecption("La fecha de entrada y salida son obligatorias.");
        }
        for (DtoHabitacion hab : nuevaReserva.getListaHabitacion()) {
            if (!daoHabitacion.estaDisponibleEstado(hab)) {
                throw new HabitacionException("La habitación " + hab.getNumero() + " no está disponible (estado: " + hab.getEstado() + ").");
            }
        }

        if (!daoReserva.habitacionDisponible(nuevaReserva)) {
            throw new ReservaExecption("Ya existe una reserva para estas fechas en una o más habitaciones seleccionadas.");
        }

        daoReserva.guardarReserva(nuevaReserva);
        for (DtoHabitacion hab : nuevaReserva.getListaHabitacion()) {
            daoHabitacion.actualizarEstado(hab.getNumero(), "ocupada");
        }

        return true;
    }

    public boolean eliminarReserva(int idReserva) {
        if (idReserva <= 0) {
            throw new IdentificadorException("El id de la reserva no puede ser negativo.");
        }
        DtoReserva nuevaReserva = daoReserva.buscarReserva(idReserva);
        if (nuevaReserva == null) {
            throw new ReservaExecption("No se encontro la reserva con el Id: " + idReserva);
        }
        boolean eliminar = daoReserva.eliminarReserva(idReserva);
        if (!eliminar) {
            throw new ReservaExecption("No se pudo eliminar la reserva con Id: " + idReserva);
        }
        return true;

    }
    public boolean editarReserva(DtoReserva reserva){
  if (reserva == null) {
            throw new ReservaExecption("La reserva no puede ser nula");
        }
        if (reserva.getIdReserva() <= 0) {
            throw new IdentificadorException("El Id de la reserva no puede ser menor a cero.");
        }
        if (reserva.getFechaEntrada() == null
                || reserva.getFechaSalida() == null) {
            throw new ReservaExecption("La fecha de entrada y salida son obligatorias.");
        }
    
    DtoReserva res = daoReserva.buscarReserva(reserva.getIdReserva());
    if (res!= null){
        return daoReserva.editarReserva(reserva);
    }else{
        throw new ReservaExecption("No se encontró una reserva con el ID: " + reserva.getIdReserva());
    }
    }
}