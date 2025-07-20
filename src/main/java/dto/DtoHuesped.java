/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import modelo.*;

/**
 *
 * @author Kevin
 */
public class DtoHuesped {
    private String nombre;
    private String documento;
    private String correo;
    private String telefono;

    public DtoHuesped(String nombre, String documento, String correo, String telefono) {
        this.nombre = nombre;
        this.documento = documento;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        if ( documento == null || documento.isBlank()){
            throw new IllegalArgumentException("El documento no puede estar vacio");
        }
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if(correo == null || correo.isBlank() ){
            throw new IllegalArgumentException("El correo no puede estar vacio");
        }
        if(!correo.contains("@")){
            throw new IllegalArgumentException("El correo debe tener un @.");
        }
            
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if(telefono == null || telefono.isBlank()){
            throw new IllegalArgumentException("El telefono no puede estar vacio");
        }
        this.telefono = telefono;
    }
    
}
