import Tablas.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginAccesDB {
private static Connection con = Connections.getCon();

    public List<Login> getLogins() throws SQLException{

        String sql = "SELECT * FROM login";
        try(Statement statement = con.createStatement()) {
            List<Login> lg = new ArrayList<>();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                Login login  = new Login();
                login.setId(rs.getInt(1));
            }
        }
        return null;
    }
}
