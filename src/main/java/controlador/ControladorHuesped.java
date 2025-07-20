/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import daos.DaoHuesped;
import dto.DtoHuesped;

public class ControladorHuesped {

    private DaoHuesped dao;

    public ControladorHuesped() {
        this.dao = new DaoHuesped();
    }

    public boolean guardarHuesped(DtoHuesped huesped) {
        DtoHuesped confirmar = dao.buscarHuesped(huesped.getDocumento());
        if (confirmar != null) {
            return false;
        } else {
            return dao.guardarHuesped(huesped);
        }
    }

    public DtoHuesped buscarHuesped(String documento) {
        if (documento == null || documento.isBlank()) {
            return null;
        } else {
            return dao.buscarHuesped(documento);
        }
    }

    public boolean eliminarHuesped(String documento) {
        if (documento == null || documento.isBlank()) {
            return false;
        }
        DtoHuesped verificar = dao.buscarHuesped(documento);
        if (verificar != null) {
            return dao.eliminarHuesped(documento);
        } else {
            return false;
        }
    }

    public boolean editarHuesped(DtoHuesped huesped) {
        if (huesped == null || huesped.getDocumento() == null || huesped.getDocumento().isBlank()) {
            return false;
        }

        DtoHuesped editar = dao.buscarHuesped(huesped.getDocumento());
        if (editar != null) {
            return dao.editarHuesped(huesped);
        } else {
            return false;
        }
    }
}
