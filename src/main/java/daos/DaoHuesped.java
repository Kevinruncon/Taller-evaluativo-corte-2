/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import dto.DtoHuesped;
import java.util.ArrayList;
import java.util.Arrays;
import modelo.Huesped;

/**
 *
 * @author Kevin
 */
public class DaoHuesped {
    ArrayList<DtoHuesped> ListaHuesped = new ArrayList<>();

    public DaoHuesped() {
    }
    
     public boolean guardarHuesped(DtoHuesped huesped) {
        for (DtoHuesped m : ListaHuesped){
            if( m.getDocumento()== (huesped.getDocumento())){
                return false;
            }
        }
        ListaHuesped.add(huesped);
        return true;
    }

    public boolean actualizarHuesped(DtoHuesped huesped) {
        for (DtoHuesped m : ListaHuesped) {
            if (m.getDocumento().equals(huesped.getDocumento())) {
                m.setCorreo(huesped.getCorreo());
                m.setNombre(huesped.getNombre());
                m.setTelefono(huesped.getTelefono());
                return true;
            }
        }
        return false;
    }
    public ArrayList<DtoHuesped> getHuespedes() {
    return ListaHuesped;
}


    public boolean eliminarHuesped(String documento) {
        for (DtoHuesped m : ListaHuesped) {
            if (m.getDocumento().equals(documento)) {
                ListaHuesped.remove(m);
                return true;
            }
        }
        return false;
    }

    public DtoHuesped buscarHuesped (String documento) {
        for (DtoHuesped m : ListaHuesped) {
            if (m.getDocumento().equals(documento)) {
                return m;
            }
        }
        return null;
    }

 
}
