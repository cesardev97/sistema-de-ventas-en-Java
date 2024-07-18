package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Jean
 */
public class Conexion {

    //conexion local
    public static Connection conectar() {
        try {

// conexión antigua por si es necesario
//            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_pizza", "root", "");
// base de pruebas
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/panchispizza", "root", "root");

            return cn;

        } catch (SQLException e) {
            System.out.println("Error en la conexion local" + e);

        }
        return null;
    }

}
