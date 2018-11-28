package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Editorial;

/*
 * @author Raul Ferri
 */

public class EditorialDAO //DAO es Data Acces Object
{
    public static boolean registrar(Editorial edi)
    {
        try 
        {
            String SQL = "INSERT INTO editoriales (nit, nombre, telefono, direccion, email, sitioweb) VALUES (?,?,?,?,?,?);";
            Connection con = Conexion.conectar();//Conectamos con la base de datos
            PreparedStatement st = con.prepareStatement(SQL);//Preparamos la sentencia SQL para su procesado
            st.setString(1, edi.getNit());
            st.setString(2, edi.getNombre());
            st.setString(3, edi.getTelefono());
            st.setString(4, edi.getDireccion());
            st.setString(5, edi.getEmail());
            st.setString(6, edi.getSitioweb());
            
            if(st.executeUpdate() > 0)//Ejecutamos la sentencia y comprobamos su correcto funcionamiento
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
        String SQL = "DELETE FROM editoriales WHERE nombre = ?;";//Cuando hay una interrogacion significa que despues se le tendra que asignat un valor con el setString
        Connection con = Conexion.conectar();//Conectamos con la base de datos
        try 
        {
            PreparedStatement st = con.prepareStatement(SQL);//Preparamos la sentencia SQL para su procesado
            st.setString(1, edi.getNombre());
            
            if(st.executeUpdate() > 0)//Ejecutamos la sentencia y comprobamos su correcto funcionamiento
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
            Connection con = Conexion.conectar();//Conectamos con la base de datos
            PreparedStatement st = con.prepareStatement (SQL); //Preparamos la sentencia SQL para su procesado
            ResultSet resultado = st.executeQuery();//Añade en resultado el valor devuelto por la query(Consulta SQL)
            ArrayList<Editorial> lista = new ArrayList<>();
            Editorial edi;
            
            while (resultado.next())//Recorremos el ResultSet leyendo todas las tuplas de la tabla editoriales
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
    
    public static boolean actualizar(Editorial edi)
    {
        try
        {
            String SQL = "UPDATE editoriales SET nit=?,telefono=?,direccion=?,email=?,sitioweb=?  WHERE nombre=?;";
            Connection con = Conexion.conectar();//Conectamos con la base de datos
            PreparedStatement st = con.prepareStatement (SQL); //Preparamos la sentencia SQL para su procesado
            
            st.setString(1, edi.getNit());
            st.setString(2, edi.getTelefono());
            st.setString(3, edi.getDireccion());
            st.setString(4, edi.getEmail());
            st.setString(5, edi.getSitioweb());
            st.setString(6, edi.getNombre());
            
            if(st.executeUpdate()>0)//Ejecutamos la sentencia y comprobamos su correcto funcionamiento
                return true;
            else
                return false;
        }
        catch(SQLException ex)
        {
            return false;
        }
    }
    
    public static String getEditorial(String nit)//Este metodo sirve para que al listar los libros, podamos obtener los datos de la editorial a la que pertenece el libro en vez de mostrar el codigo de la editorial sin mas
    {
        try 
        {
            String SQL = "SELECT nombre FROM editoriales WHERE nit=?";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement (SQL); 
            st.setString(1, nit);
            ResultSet resultado = st.executeQuery();
           
            if (resultado.next())//Si encuentra la editorial devuelve el nombre de la misma
            {
               return resultado.getString("nombre");
            }
            return "--";//Si no la encuentra devuelve valor vacio para que no pete el programa

        } 
        catch (SQLException ex) 
        {
            return "--";
        }
    }
}
