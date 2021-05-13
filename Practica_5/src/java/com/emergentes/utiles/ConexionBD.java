package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {

    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_blog";
    static String usuario = "root";
    static String password = "";

    protected Connection conn = null;

    public ConexionBD() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario,password);
            if (conn != null) {
                System.out.println("Conexion ok " + conn);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() {
        System.out.println("Cerrando la base de datos " + conn);
        try {
            conn.close();
        } catch (SQLException ex) {
                System.out.println("Error al cerrar "+ex.getMessage());
        }
    }

}
