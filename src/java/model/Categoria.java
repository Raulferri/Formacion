package model;

import java.io.Serializable;

/*
 * @author Arranque 4
 */

public class Categoria implements Serializable 
{

    private int codigo;
    private String nombre;

    public Categoria() 
    {
        this.codigo = 0;
        this.nombre = "";
    }

    public Categoria(int codigo, String nombre) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) 
    {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public int getCodigo() 
    {
        return codigo;
    }

    public String getNombre() 
    {
        return nombre;
    }
}