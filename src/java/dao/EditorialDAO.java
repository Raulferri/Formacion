package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Editorial;

/*
 * @author Arranque 4
 */

public class EditorialDAO 
{
    public static boolean registrar(Editorial edi)
    {
        try 
        {
            String SQL = "INSERT INTO editoriales (nit, nombre, telefono, direccion, email, sitioweb) VALUES (?,?,?,?,?,?);";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, edi.getNit());
            st.setString(2, edi.getNombre());
            st.setString(3, edi.getTelefono());
            st.setString(4, edi.getDireccion());
            st.setString(5, edi.getEmail());
            st.setString(6, edi.getSitioweb());
            
            if(st.executeUpdate() > 0)
                return true;
            else
                return false;
        } 
        catch (SQLException ex) 
        {
            return false;
        }
    }
    
    public static boolean eliminar(Editorial edi)
    {
        String SQL = "DELETE FROM editoriales WHERE nombre = ?;";
        Connection con = Conexion.conectar();
        try 
        {
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, edi.getNombre());
            
            if(st.executeUpdate() > 0)
                return true;
            else
                return false;
        } 
        catch (SQLException ex) 
        {
            return false;
        }
    }
    
    public static ArrayList<Editorial> listar()
    {
        try 
        {
            String SQL = "SELECT * FROM editoriales";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement (SQL); 
            ResultSet resultado = st.executeQuery();
            ArrayList<Editorial> lista = new ArrayList<>();
            Editorial edi;
            
            while (resultado.next())
            {
                edi = new Editorial();
                edi.setNit(resultado.getString("nit"));
                edi.setNombre(resultado.getString("nombre"));
                edi.setTelefono(resultado.getString("telefono"));
                edi.setDireccion(resultado.getString("direccion"));
                edi.setEmail(resultado.getString("email"));
                edi.setSitioweb(resultado.getString("sitioweb"));
                lista.add(edi);
            }
            
            return lista;

        } 
        catch (SQLException ex) 
        {
            return null;
        }
    }
}