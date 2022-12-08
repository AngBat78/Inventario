package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexion cn = new conexion();

    public login log(String correo, String pass) {
        login l = new login();
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND pass = ?";
        try
        {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next())
            {
                l.setId_empleado(rs.getInt("id_empleado"));
                l.setNombre(rs.getString("nombre"));
                l.setCorreo(rs.getString("correo"));
                l.setPass(rs.getString("pass"));
                

            }
        } catch (SQLException e)
        {
            System.out.println("e.toString()");
        }
        return l;
    }
}
