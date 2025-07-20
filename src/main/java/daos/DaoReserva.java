/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import dto.DtoHabitacion;
import java.util.ArrayList;
import dto.DtoReserva;
import java.time.LocalDate;

/**
 *
 * @author Kevin
 */
public class DaoReserva {
    ArrayList<DtoReserva> ListaReserva = new ArrayList<>();

    public DaoReserva() {
    }
    
    public boolean guardarReserva(DtoReserva reserva){
        for(DtoReserva r : ListaReserva){
           if(r.getIdReserva()== reserva.getIdReserva()){
               return false;
           }           
        }
        return guardarReserva(reserva);
    }
    public boolean editarReserva(DtoReserva reserva) {
        for (DtoReserva r : ListaReserva) {
            if (r.getIdReserva() == reserva.getIdReserva()) {
                r.setFechaEntrada(reserva.getFechaEntrada().toString());
                r.setFechaSalida(reserva.getFechaSalida().toString());
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<DtoReserva> getReserva() {
    return ListaReserva;
}


    public boolean eliminarReserva(int idReserva) {
        for (DtoReserva r : ListaReserva) {
            if (r.getIdReserva() ==  idReserva) {
                ListaReserva.remove(r);
                return true;
            }
        }
        return false;
    }

    public DtoReserva buscarReserva(int idReserva) {
        for (DtoReserva r : ListaReserva) {
            if (r.getIdReserva()== idReserva) {
                return r;
            }
        }
        return null;
    }

    public boolean habitacionDisponible(DtoReserva ReservaNueva){
        for(DtoReserva r : ListaReserva){
            for(DtoHabitacion hab : ReservaNueva.getListaHabitacion()){
                if(r.getListaHabitacion().contains(hab)&& ReservaNueva.getFechaEntrada().isBefore(r.getFechaSalida())
                        && ReservaNueva.getFechaSalida().isAfter(r.getFechaEntrada())){
                    return false;
            }
            }
        }
        return true;
    }
    

}
