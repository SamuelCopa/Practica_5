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
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginSession", urlPatterns = {"/LoginSession"})
public class LoginSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        String login = (String) ses.getAttribute("login");
        if (login.equals("OK")) {
            ses.invalidate();
            //response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession ses = request.getSession();
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("contraseña");
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> datos = new ArrayList<Usuario>();
            
            dao.getAll(usuario, password);
            if ((usuario.equals("usuario")) && (password.equals("password"))) {
                ses.setAttribute("login", "OK");
                ses.setAttribute("usuario", usuario);
                
                response.sendRedirect("panel.jsp");
            } else {
                ses.setAttribute("error", "Usuario sin Autorización");
                response.sendRedirect("login.jsp");
                
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginSession.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

}
