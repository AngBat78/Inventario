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
import javax.swing.JOptionPane;

/**
 *
 * @author Prueba 1
 */
public class ClienteDAO {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarCliente(Cliente cl) {
        String sql = "INSERT INTO clientes (id_cliente, nombre, apellido, telefono, direccion) VALUES (?,?,?,?,?)";
        try
        {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getId_cliente());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getApellido());
            ps.setString(4, cl.getTelefono());
            ps.setString(5, cl.getDireccion());
            ps.execute();
            return true;
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
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

    public List ListarCliente() {
        List<Cliente> ListaCl = new ArrayList();
        String sql = "SELECT *FROM clientes";
        try
        {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next())
            {
                Cliente cl = new Cliente();
                cl.setId_cliente(rs.getInt("Id_cliente"));
                cl.setNombre(rs.getString("nombre"));
                cl.setApellido(rs.getString("apellido"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                ListaCl.add(cl);
            }
            {

            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return ListaCl;
    }

    public boolean EliminarCliente(int Id_cliente){
        String sql = "DELETE FROM clientes WHERE Id_cliente = ?";
        try
        {
           ps = con.prepareStatement(sql);
           ps.setInt(1, Id_cliente);
           ps.execute();
           return true;
        } catch (SQLException e)
        {
            System.out.println(e.toString());
            return false;
        }finally{
            try
            {
                con.close();
            } catch (SQLException ex)
            {
                System.out.println(ex.toString());
            }
        }
    }
     public boolean ModificarCliente(Cliente cl){
       String sql = "UPDATE clientes SET nombre=?, apellido=?, telefono=?, direccion=? WHERE id_cliente=?";
       try {
           ps = con.prepareStatement(sql);   
           ps.setString(1, cl.getNombre());
           ps.setString(2, cl.getApellido());
           ps.setString(3, cl.getTelefono());
           ps.setString(4, cl.getDireccion());
           ps.setInt(5, cl.getId_cliente());
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
