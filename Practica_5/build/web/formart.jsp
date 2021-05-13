<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${articulo.id==0}" var="res">Nuevo</c:if>
            <c:if test="${articulo.id!=0}" var="res">Editar</c:if>
            articulo
        </h1>
            
            <form action="Inicio" method="post">
                <input type="hidden" name="id" value="${articulo.id}">
            <table>
                <tr>
                    <td>Fecha</td>
                    <td><input type="date" name="fecha" value="${articulo.fecha}"></td>
                </tr>
                <tr>
                    <td>Titulo</td>
                    <td><input type="text" name="titulo" value="${articulo.titulo}"></td>
                </tr>
                <tr>
                    <td>Contenido</td>
                    <td><textarea name="contenido" rows="4" cols="20">${articulo.contenido}</textarea></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"></td>
                </tr>
            </table>
            </form>
    </body>
</html>
