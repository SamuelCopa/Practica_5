

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>


    <h1>Blog de salud</h1>
    <p><a href="Inicio?action=add">Nueva entrada</a></p>

    <table>
        <c:forEach var="item" items="${articulos}">
            <tr>
                <td><p><input type="date" value="${item.fecha}"></p></td>
            </tr>   
            <tr>
                <td><b>${item.titulo}</b></td>
            </tr>
            <tr>
                <td>${item.contenido}<td>
            </tr>
            <tr>                
                <td align="right"><a href="Inicio?action=edit&id=${item.id}" >Editar</a>
                    <a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro ?'))">Eliminar</a></td>

            </tr>
            <tr>
                <td><hr></td>
            </tr>

        </tr>
        <tr>

        </tr>


    </c:forEach>
</table>

</html>
