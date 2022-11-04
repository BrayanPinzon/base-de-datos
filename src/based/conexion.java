package based;

import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion {

    String user = "root";
    String url = "jdbc:mysql://localhost/";
    String password = "";
    String base = "persona";
    String driver = "com.mysql.jdbc.Driver";
    Connection c;

    public conexion() {
    }

    public Connection conectar() {
        try {
            Class.forName(driver);
            c = DriverManager.getConnection("jdbc:mysql://localhost/persona", "root", "");
            JOptionPane.showMessageDialog(null, "hola");
        } catch (ClassNotFoundException | SQLException e) {
        }
        return null;

    }

    public Statement mostrar() {
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from persona");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("nombre") + " " + rs.getDate("nacimiento"));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public Connection cerrar() {
        try {
            c.close();
            JOptionPane.showMessageDialog(null, "se cerro");
        } catch (SQLException e) {
        }
        return null;
    }

}
