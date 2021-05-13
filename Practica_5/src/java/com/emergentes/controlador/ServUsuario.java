package com.emergentes.controlador;

import com.emergentes.dao.UsuarioDAO;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServUsuario", urlPatterns = {"/ServUsuario"})
public class ServUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = "";
        String contraseña = "";
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> datos = new ArrayList<Usuario>();

        if (request.getParameter("inicio") != null) {
            try {
                usuario = request.getParameter("usuario");
                contraseña = request.getParameter("password");
                datos = dao.accesar(usuario, contraseña);
                if (datos.size() > 0) {
                    request.setAttribute("datos", datos);
                    request.getRequestDispatcher("usuario.jsp").forward(request, response);
                } else {
                    request.setAttribute("fail", "No hay acceso!");
                    request.getRequestDispatcher("usuario.jsp").forward(request, response);
                }
            } catch (Exception ex) {
                Logger.getLogger(ServUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
