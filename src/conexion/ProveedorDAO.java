/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prueba 1
 */
public class ProveedorDAO {

    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarProveedor(Proveedor pr) {
        String sql = "INSERT INTO proveedor(id_prov, nombre, telefono, correo, direccion) VALUES(?,?,?,?,?)";
        try
        {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getId_prov());
            ps.setString(2, pr.getNombre());
            ps.setString(3, pr.getTelefono());
            ps.setString(4, pr.getCorreo());
            ps.setString(5, pr.getDireccion());
            ps.execute();
            return true;
        } catch (SQLException e)
        {
            System.out.println(e.toString());
            return false;
        } finally
        {
            try
            {
                con.close();
            } catch (SQLException e)
            {
                System.out.println(e.toString());
            }
        }
    }

    public List ListarProveedor() {
        List<Proveedor> Listapr = new ArrayList();
        String sql = "SELECT * FROM proveedor";
        try
        {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Proveedor pr = new Proveedor();
                
                pr.setId_prov(rs.getInt("id_prov"));
                pr.setNombre(rs.getString("nombre"));
                pr.setTelefono(rs.getString("telefono"));
                pr.setCorreo(rs.getString("correo"));
                pr.setDireccion(rs.getString("direccion"));
                Listapr.add(pr);
            }
                    
        } catch (SQLException e)
        {
            System.out.println(e.toString());
        }
        return Listapr;
        }
    
    public boolean EliminarProveedor(int Id_prov){
        String sql = "DELETE FROM proveedor WHERE Id_prov = ? ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Id_prov);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    public boolean ModificarProveedor(Proveedor pr){
        String sql = "UPDATE proveedor SET nombre=?, telefono=?, correo=?, direccion=? WHERE id_prov=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(5, pr.getId_prov());
            ps.setString(1, pr.getNombre());
            ps.setString(2, pr.getTelefono());
            ps.setString(3, pr.getCorreo());
            ps.setString(4, pr.getDireccion()); 
            
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}
    
