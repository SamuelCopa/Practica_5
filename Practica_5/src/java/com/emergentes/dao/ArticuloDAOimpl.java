package com.emergentes.dao;

import com.emergentes.modelo.Articulo;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Sammy
 */
public class ArticuloDAOimpl extends ConexionBD implements ArticuloDAO {

    @Override
    public void insert(Articulo articulo) throws Exception {
        try {
            this.conectar();
            String sql = "insert into posts(fecha,titulo,contenido) values(?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, articulo.getFecha());
            ps.setString(2, articulo.getTitulo());
            ps.setString(3, articulo.getContenido());

            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public void update(Articulo articulo) throws Exception {
        try {
            this.conectar();
            String sql = "update posts set fecha=?,titulo=?,contenido=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, articulo.fecha);
            ps.setString(2, articulo.getTitulo());
            ps.setString(3, articulo.getContenido());
            ps.setInt(4, articulo.getId());

            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from posts where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Articulo getById(int id) throws Exception {
        Articulo ar = new Articulo();
        try {
            this.conectar();
            String sql = "select * from posts where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ar.setId(rs.getInt("id"));
                ar.setFecha(rs.getString("fecha"));
                ar.setTitulo(rs.getString("titulo"));
                ar.setContenido(rs.getString("contenido"));
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return ar;
    }

    @Override
    public List<Articulo> getAll() throws Exception {
        List<Articulo> lista = null;

        try {
          
            this.conectar();
            String sql = "select * from posts";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Articulo>();

            while (rs.next()) {
                Articulo ar = new Articulo();
                ar.setId(rs.getInt("id"));
                ar.setFecha(rs.getString("fecha"));
                ar.setTitulo(rs.getString("titulo"));
                ar.setContenido(rs.getString("contenido"));

                lista.add(ar);
            }
            rs.close();
            ps.close();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
