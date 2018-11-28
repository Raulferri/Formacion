package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;

/**
 *
 * @author Arranque 4
 */
public class CategoriaDAO 
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
        Connection con = Conexion.conectar();
        try 
        {
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, cat.getNombre());
            
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
}
