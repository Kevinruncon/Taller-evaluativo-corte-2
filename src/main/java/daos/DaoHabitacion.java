/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;
import dto.DtoHabitacion;
import java.util.ArrayList;
/**
 *
 * @author Kevin
 */
public class DaoHabitacion {
   private ArrayList<DtoHabitacion> ListaHabitacion = new ArrayList<>();

    public DaoHabitacion() {
    }
    
    public boolean guardarHabitacion(DtoHabitacion habitacion){
        for(DtoHabitacion m : ListaHabitacion){
           if(m.getNumero() == habitacion.getNumero()){
               return false;
           }           
        }
        return guardarHabitacion(habitacion);
    }
    public boolean editarHabitacion(DtoHabitacion habitacion) {
        for (DtoHabitacion m : ListaHabitacion) {
            if (m.getNumero()== habitacion.getNumero()) {
                m.setCapacidad(habitacion.getCapacidad());
                m.setEstado(habitacion.getEstado());
                m.setTipo(habitacion.getTipo());
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<DtoHabitacion> getListaHabitaciones() {
    return ListaHabitacion;
}


    public boolean eliminarHabitacion(int numero) {
        for (DtoHabitacion m : ListaHabitacion) {
            if (m.getNumero()==  numero) {
                ListaHabitacion.remove(m);
                return true;
            }
        }
        return false;
    }

    public DtoHabitacion buscarHabitacion(int numero) {
        for (DtoHabitacion m : ListaHabitacion) {
            if (m.getNumero()== numero) {
                return m;
            }
        }
        return null;
    }

   public boolean estaDisponibleEstado(DtoHabitacion habitacion) {
        String estado = habitacion.getEstado().toLowerCase();
        return estado.equals("libre");
    }    
   

   public boolean actualizarEstado(int numero, String nuevoEstado) {
    for (DtoHabitacion h : ListaHabitacion) {
        if (h.getNumero() == numero) {
            h.setEstado(nuevoEstado);
            return true;
        }
    }
    return false;
}
}

