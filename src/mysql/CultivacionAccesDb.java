package mysql;

import Model.Cultivacion;
import Model.Personajes;
import util.DatabaseConection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CultivacionAccesDb {
    private final static Connection con = DatabaseConection.getCon();

    public static List<Cultivacion> getCultivacion(){

        String select = "SELECT * FROM cultivacion";
        List <Cultivacion> cultivacions = new ArrayList<>();
        try(Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery(select);
            while (rs.next()){
                Cultivacion cultivacion = new Cultivacion();
                cultivacion.setEtapa(rs.getString("etapa"));
                cultivacion.setTipo(rs.getString("tipo"));
                cultivacion.setTecnica(rs.getString("tecnica"));
                cultivacions.add(cultivacion);
            }
        } catch (SQLException e) {
            System.out.println("Problema con la conexion a la base de datos");
        }
        return cultivacions;
    }
    public static int insertCultivacion (Cultivacion cultivacion){
        String insertCulti = "INSERT INTO Cultivacion(etapa ,tipo , tecnica)" +
                "VALUES (?,?,?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(insertCulti , Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,cultivacion.getEtapa());
            preparedStatement.setString(2,cultivacion.getTipo());
            preparedStatement.setString(3,cultivacion.getTecnica());

            int row = preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (row == 1 && rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Los valores de la inserccion no son correctos");
        }
        return 0;
    }
    public static int updateCultivo (Cultivacion cultivacion, String antiguo){
        String updateCultivo = "UPDATE cultivacion set etapa = ? , tipo = ? , tecnica = ?  WHERE etapa = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(updateCultivo , Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,cultivacion.getEtapa());
            preparedStatement.setString(2,cultivacion.getTipo());
            preparedStatement.setString(3,cultivacion.getTecnica());
            preparedStatement.setString(4,antiguo);

            int row = preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (row == 1 && rs.next()){
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error en el sql");
        }
        return 0;
    }
    public static boolean existeCulti (String nombre){
        String select = "SELECT COUNT(*) FROM cultivacion where etapa = ?";
        try(PreparedStatement p = con.prepareStatement(select)) {
            p.setString(1,nombre);
            ResultSet resultSet = p.executeQuery();
            if (resultSet.next()){
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error en el sql");
        }
        return false;
    }
}
