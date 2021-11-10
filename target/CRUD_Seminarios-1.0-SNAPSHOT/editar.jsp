<%@page import="com.emergentes.modelo.Registro"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%
    Registro reg = (Registro)request.getAttribute("reg");
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${reg.id == 0}">
                Nuevo Registro
            </c:if>
            <c:if test="${reg.id != 0}">
                Editar Registro
            </c:if>
        </h1>
        <form action="MainController" method="post">
            <input type="hidden" name="id" value="${reg.id}">
            <table>
            <tr>
                <td>TITULO</td>
                <td><input type="text" name="titulo" value="${reg.titulo}"></td>
                
            </tr> 
            <tr>
                <td>EXPOSITOR</td>
                <td><input type="text" name="expositor" value="${reg.expositor}" /></td>
            </tr>
                <tr>
                <td>FECHA</td>
                <td><input type="text" name="fecha" value="${reg.fecha}" /></td>
            </tr>
                <tr>
                <td>HORAS</td>
                <td><input type="text" name="hora" value="${reg.hora}" /></td>
            </tr>
                <tr>
                <td>CUPOS</td>
                <td><input type="text" name="cupo" value="${reg.cupos}" /></td>
            </tr>
                <tr>
                <td></td>
                <td><input type="submit" value="Enviar"></td>
            </tr>
            </table>
        </form>
   
        
    </body>
</html>
