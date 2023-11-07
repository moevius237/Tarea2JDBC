package mysql;

import Model.Login;
import util.DatabaseConection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginAccesDB {
private final static Connection con = DatabaseConection.getCon();
/*
    public List<Login> getLogins() throws SQLException{

        String sql = "SELECT * FROM login";
        List<Login> logins = new ArrayList<>();
        try(Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Login login  = new Login();
                login.setId(rs.getInt("id"));
                login.setUsername(rs.getString("username"));
                login.setPassword(rs.getString("pass"));
                login.setCreateadAT(rs.getTimestamp("created_at").toLocalDateTime());
                System.out.println(login);
                logins.add(login);
            }
            rs.close();
        }
        return logins;
    }

 */
    public boolean autentica(String user , String pass){
        String sql = "SELECT * FROM login WHERE user = ? AND pass = ?";
        try(PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1,user);
            statement.setString(2,pass);

            ResultSet rs = statement.executeQuery();
            return  rs.next();
        } catch (SQLException e) {
            System.out.println("HA habido un error en al autenticar usuario");
            return false;
        }
    }
}
