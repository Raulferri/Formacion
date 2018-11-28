package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;

/**
 *
 * @author Raul Ferri
 */
public class CategoriaDAO //DAO es Data Acces Object
{
    public static boolean registrar(Categoria c)
    {
        try 
        {
            String SQL = "INSERT INTO categorias (nombre) VALUES (?);";
            Connection con = Conexion.conectar();//Conectamos con la base de datos
            PreparedStatement st = con.prepareStatement(SQL);//Preparamos la sentencia SQL para su procesado
            st.setString(1, c.getNombre());
            
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
    
    public static boolean eliminar(Categoria cat)
    {
        String SQL = "DELETE FROM categorias WHERE nombre = ?;";
        Connection con = Conexion.conectar();//Conectamos con la base de datos
        try 
        {
            PreparedStatement st = con.prepareStatement(SQL);//Preparamos la sentencia SQL para su procesado
            st.setString(1, cat.getNombre());
            
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
    
    public static ArrayList<Categoria> listar()
    {
        try 
        {
            String SQL = "SELECT * FROM categorias";
            Connection con = Conexion.conectar();//Conectamos con la base de datos
            PreparedStatement st = con.prepareStatement (SQL); //Preparamos la sentencia SQL para su procesado
            ResultSet resultado = st.executeQuery();//Añade en resultado el valor devuelto por la query(Consulta SQL)
            ArrayList<Categoria> lista = new ArrayList<>();
            Categoria cat;
            
            while (resultado.next())
            {
                cat = new Categoria();
                cat.setCodigo(resultado.getInt("codigo"));
                cat.setNombre(resultado.getString("nombre"));
                lista.add(cat);
            }
            
            return lista;

        } 
        catch (SQLException ex) 
        {
            return null;
        }
    }
}
