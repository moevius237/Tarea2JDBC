package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConection {
    private static Connection con = null;
    static {
        Properties properties = new Properties();
        try{
        properties.load(Files.newBufferedReader(Path.of("Datasource.properties")));
        con = DriverManager.getConnection(properties.getProperty("db.url"),
            properties.getProperty("db.user"),
            properties.getProperty("db.password"));


        }catch(SQLException e){
            System.out.println("Ha habido un error en el sql" + e.getMessage());
    } catch (IOException e) {
            System.out.println("HA habido un error al encontrar el archvo datasource.propierties"+
                    e.getMessage());
        }
    }
    private DatabaseConection(){
    }
    public static Connection getCon(){
        return con;
    }
    public static void main(String [] args) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Hubo un problema al cerrar la conexión" + e.getMessage());
            }
        }
    }
}
