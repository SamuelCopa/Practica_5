package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    ConexionBD con = new ConexionBD();

    public List<Usuario> accesar(String usuario, String contraseña) {
        List<Usuario> datos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "select usuario, password from usuarios "
                + "where usuario='" + usuario + "' and password='" + contraseña
                + "'";
        try {
            con.conectar();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario ar = new Usuario();

                ar.setUsuario(usuario);
                ar.setContraseña(contraseña);

                datos.add(ar);
            }
            conn.close();
        } catch (SQLException e) {

        }
        return datos;
    }

    public List<Usuario> getAll(String usuario,String contraseña) throws Exception {
        ConexionBD con = new ConexionBD();
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs;
       
        List<Usuario> datos = null;

        try {
            con.conectar();

            String sql = "select usuario, password from usuarios "
                + "where usuario='" + usuario + "' and password='" + contraseña + "'";
            ps=conn.prepareStatement(sql);

            rs = ps.executeQuery();
            datos = new ArrayList<Usuario>();

            while (rs.next()) {
                Usuario ar = new Usuario();
                ar.setId(rs.getInt("id"));
                ar.setUsuario(rs.getString("usuario"));
                ar.setContraseña(rs.getString("password"));               

                datos.add(ar);
            }
            rs.close();
            ps.close();

        } catch (Exception ex) {
            throw ex;
        } finally {
            con.desconectar();
        }
        return datos;
    }

}
