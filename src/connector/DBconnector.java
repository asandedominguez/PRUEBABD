package connector;

import java.sql.Connection;
import java.sql.DriverManager;
// PERFECTO
public class DBconnector {
    public static Connection conexion () {
        Connection conn = null;
        try {
            String url = "jbdc:postgresql:/10.0.9.226:5432/probas";
            String user = "postgres";
            String passwd = "admin";

            conn = DriverManager.getConnection(url, user, passwd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
