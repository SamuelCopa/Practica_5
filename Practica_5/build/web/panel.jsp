

<%
    if (session.getAttribute("login") != "OK") {
            response.sendRedirect("Login.jsp");
        }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido <%= session.getAttribute("usuario") %></h1>
        <table>
            <tr>
                <td></td>
            </tr>
        </table>
        <p>Bienvenido a nuestro blog </p>
        <a href="Inicio?action=add">Ingresar ahora</a>
        <a href="login.jsp"></a>
    </body>
</html>