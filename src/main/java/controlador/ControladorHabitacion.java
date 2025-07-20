/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import daos.DaoHabitacion;
import dto.DtoHabitacion;

/**
 *
 * @author Kevin
 */
public class ControladorHabitacion {
    
   private DaoHabitacion dao;

    public ControladorHabitacion() {
        this.dao = new DaoHabitacion();
    }
    
    public boolean guardarHabitacion(DtoHabitacion habitacion){
        if (habitacion.getNumero() <= 0 ){
            return false;
        }   
        
        DtoHabitacion confirmacion = 
    }
   
    
}
