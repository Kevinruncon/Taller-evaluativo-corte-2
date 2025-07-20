/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Exceptiones.HabitacionException;
import Exceptiones.HuespedException;
import daos.DaoHuesped;
import dto.DtoHuesped;
import  Exceptiones.IdentificadorException;
import Exceptiones.ReservaExecption;
import dto.DtoHabitacion;
import java.util.ArrayList;

public class ControladorHuesped {

    private DaoHuesped daoHuesped;

    public ControladorHuesped() {
        this.daoHuesped = new DaoHuesped();
    }

    public boolean guardarHuesped(DtoHuesped huesped) {
        if (huesped == null) {
            throw new HuespedException("El huésped no puede ser nulo.");
        }
        if (huesped.getDocumento() == null || huesped.getDocumento().isBlank()) {
            throw new IdentificadorException("El documento del huésped es obligatorio.");
        }

        DtoHuesped confirmar = daoHuesped.buscarHuesped(huesped.getDocumento());
        if (confirmar != null) {
            throw new HuespedException("Ya existe un huésped con ese documento.");
        }

        return daoHuesped.guardarHuesped(huesped);
    }

    public DtoHuesped buscarHuesped(String documento) {
        if (documento == null || documento.isBlank()) {
            throw new IdentificadorException("El documento no puede estar vacío.");
        }

        DtoHuesped huesped = daoHuesped.buscarHuesped(documento);
        if (huesped == null) {
            throw new HuespedException("No se encontró un huésped con el documento: " + documento);
        }

        return huesped;
    }

    public boolean eliminarHuesped(String documento) {
        if (documento == null || documento.isBlank()) {
            throw new IdentificadorException("Debe ingresar un documento válido.");
        }

        DtoHuesped verificar = daoHuesped.buscarHuesped(documento);
        if (verificar == null) {
            throw new HuespedException("No se encontró un huésped con el documento: " + documento);
        }

        return daoHuesped.eliminarHuesped(documento);
    }

    public boolean editarHuesped(DtoHuesped huesped) {
        if (huesped == null) {
            throw new HuespedException("El objeto huésped no puede ser nulo.");
        }
        if (huesped.getDocumento() == null || huesped.getDocumento().isBlank()) {
            throw new IdentificadorException("El documento del huésped es obligatorio para editar.");
        }

        DtoHuesped existente = daoHuesped.buscarHuesped(huesped.getDocumento());
        if (existente == null) {
            throw new HabitacionException("No se encontró un huésped con el documento: " + huesped.getDocumento());
        }

        return daoHuesped.editarHuesped(huesped);
    }
        public ArrayList<DtoHuesped> getListaHuesped() {
        return daoHuesped.getHuespedes();
        }
}
