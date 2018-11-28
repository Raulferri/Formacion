/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Raul Ferri
 */
public class Editorial implements Serializable
{
    private String nit;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    private String sitioweb;

    public Editorial() 
    {
        this.nit = "";
        this.nombre = "";
        this.telefono = "";
        this.direccion = "";
        this.email = "";
        this.sitioweb = "";
    }

    public Editorial(String nit, String nombre, String telefono, String direccion, String email, String sitioweb) 
    {
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.sitioweb = sitioweb;
    }

    public String getNit() 
    {
        return nit;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public String getTelefono() 
    {
        return telefono;
    }

    public String getDireccion() 
    {
        return direccion;
    }

    public String getEmail() 
    {
        return email;
    }

    public String getSitioweb() 
    {
        return sitioweb;
    }

    public void setNit(String nit) 
    {
        this.nit = nit;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) 
    {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) 
    {
        this.direccion = direccion;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public void setSitioweb(String sitioweb) 
    {
        this.sitioweb = sitioweb;
    }
}
