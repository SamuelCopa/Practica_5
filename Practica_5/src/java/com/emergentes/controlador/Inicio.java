package com.emergentes.controlador;

import com.emergentes.dao.ArticuloDAO;
import com.emergentes.dao.ArticuloDAOimpl;

import com.emergentes.modelo.Articulo;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        try {
            ArticuloDAO dao = new ArticuloDAOimpl();
            int id;
            Articulo ar = new Articulo();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("articulo", ar);
                    request.getRequestDispatcher("formart.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    ar = dao.getById(id);
                    System.out.println(ar);
                    request.setAttribute("articulo", ar);
                    request.getRequestDispatcher("formart.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Inicio");
                    break;
                case "view":
                    List<Articulo> lista = dao.getAll();
                    request.setAttribute("articulos", lista);
                    request.getRequestDispatcher("posts.jsp").forward(request, response);
                default:
                    break;
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));       
        String fecha=request.getParameter("fecha");
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");

        Articulo ar = new Articulo();

        ar.setId(id);
        ar.setFecha(fecha);
        ar.setTitulo(titulo);
        ar.setContenido(contenido);

        if (id == 0) {
            try {
                ArticuloDAO dao = new ArticuloDAOimpl();
                dao.insert(ar);
                response.sendRedirect("Inicio");

            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        } else {
            try {
                ArticuloDAO dao = new ArticuloDAOimpl();
                dao.update(ar);
                response.sendRedirect("Inicio");
                
            } catch (Exception ex) {
                System.out.println("Error "+ex.getMessage());
            }
        }
    }

}
