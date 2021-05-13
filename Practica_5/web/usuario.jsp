

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><br>
        <h1>Formulario de Acceso</h1>

        <form  action="ServUsuario" method="POST">
            <input type="hidden" name="id">
            <table>
                <tr>
                    <td>Usuario</td>
                    <td> <input type="text" name="usuario" value="" size="30"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td> <input type="password" name="contraseña" value="" size="30" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Iniciar Sesion" name="inicio" /></td>
                </tr>

            </table>


        </form>

        <%
            HttpSession sesion = request.getSession();

            List<Usuario> datos = new ArrayList<Usuario>();
            if (request.getAttribute("fail") != null) {
                out.print("<script>alert('Ususario o contraseña erroneos!');</script>   ");
            }
            if (request.getAttribute("datos") != null) {
                datos = (List<Usuario>) request.getAttribute("datos");
                String usuario = "";
                String contraseña = "";
                for (Usuario u : datos) {
                    usuario = u.getUsuario();
                    contraseña = u.getContraseña();
                }
                sesion.setAttribute("usuario", usuario);
                sesion.setAttribute("password", contraseña);
                response.sendRedirect("Inicio");
            }
            if (request.getParameter("cerrar") != null) {
                sesion.invalidate();
                response.sendRedirect("usuario.jsp");
            }

        %>

    </center>
</body>
</html>

