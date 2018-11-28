package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * @author Arranque 4
 */

public class Conexion 
{
    public static Connection conectar()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");//Seleccionamos el driver de la base de datos que se va a utilizar(es importante haber añadirdo el archivo jar a las librerias
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca_bd", "root", "");
        }
        catch(ClassNotFoundException | SQLException ex)//Se pueden hacer los catch anidados pero esta mejor visto hacerlos por separado(es importante asegurarse que las excepciones anidadas no se pueden dar al mismo tiempo
        {
            return null;
        }
    }
}