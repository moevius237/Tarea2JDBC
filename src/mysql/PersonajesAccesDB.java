package mysql;

import Model.Cultivacion;
import Model.Login;
import Model.Personajes;
import util.DatabaseConection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonajesAccesDB {
    private final static Connection con = DatabaseConection.getCon();

    public static List<Personajes> getPersonajes(){

        String select = "SELECT * FROM Personajes";
        List <Personajes> personajes = new ArrayList<>();
        try(Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery(select);
            while (rs.next()){
                Personajes personajes1 = new Personajes();
                personajes1.setName(rs.getString("name"));
                personajes1.setRaza(rs.getString("raza"));
                personajes1.setEdad(rs.getInt("edad"));
                personajes1.setDao(rs.getString("dao"));
                personajes1.setCultivacionName(rs.getString("etapa"));
                personajes.add(personajes1);
            }
        } catch (SQLException e) {
            System.out.println("Problema con la conexion a la base de datos");
        }
        return personajes;
    }
    public static List <String> MostrarEtapa(){
        String selectEtapa = "SElECT etapa FROM Cultivacion";
        List <String> etapas = new ArrayList<>();
        try(Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery(selectEtapa);
            while (rs.next()){
                Cultivacion cultivacion = new Cultivacion();
                cultivacion.setEtapa(rs.getString("etapa"));
                etapas.add(cultivacion.getEtapa());
            }
        } catch (SQLException e) {
            System.out.println("HA habido un error al acceder a la tabla de etapa");
        }
        return etapas;
    }
    public static int insertPersonajes(Personajes personajes){
        String insertPersonaje = "INSERT INTO Personajes (name , raza , edad , dao , etapa)" +
                "VALUES (?,?,?,?,?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(insertPersonaje, Statement.RETURN_GENERATED_KEYS )){
            preparedStatement.setString(1,personajes.getName());
            preparedStatement.setString(2,personajes.getRaza());
            preparedStatement.setInt(3,personajes.getEdad());
            preparedStatement.setString(4, personajes.getDao());
            preparedStatement.setString(5,personajes.getCultivacionName());

            int row = preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (row == 1 && rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("INtroduce una etapa valida");
        }
        return 0;
    }
    public static int updatePerson (Personajes personajes, String antiguo){
        String updatePerson = "UPDATE Personajes set name = ? , raza = ? , edad = ? , dao = ? , etapa = ? WHERE name = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(updatePerson , Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,personajes.getName());
            preparedStatement.setString(2,personajes.getRaza());
            preparedStatement.setInt(3,personajes.getEdad());
            preparedStatement.setString(4,personajes.getDao());
            preparedStatement.setString(5,personajes.getCultivacionName());
            preparedStatement.setString(6,antiguo);

            int row = preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (row == 1 && rs.next()){
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Introduce una etapa valida");
        }
        return 0;
    }
    public static boolean existePerso (String nombre){
        String select = "SELECT COUNT(*) FROM personajes where name = ?";
        try(PreparedStatement p = con.prepareStatement(select)) {
            p.setString(1,nombre);
            ResultSet resultSet = p.executeQuery();
            if (resultSet.next()){
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            System.out.println("Ese personaje no existe");
        }
        return false;
    }
    public static void eliminarPersonaje(String name){
        String borrarPer = "DELETE FROM personajes WHERE name = ?";
        try(PreparedStatement ps = con.prepareStatement(borrarPer)) {
            ps.setString(1,name);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error con la base de datos");
        }
    }
    public static List <String> MostrarNombres(){
        String selectname = "SElECT name FROM Personajes";
        List <String> names = new ArrayList<>();
        try(Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery(selectname);
            while (rs.next()){
                Personajes personajes = new Personajes();
                personajes.setName(rs.getString("name"));
                names.add(personajes.getName());
            }
        } catch (SQLException e) {
            System.out.println("HA habido un error al acceder a la tabla de name");
        }
        return names;
    }
}
