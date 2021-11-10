<%@page import="com.emergentes.modelo.Registro"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
List<Registro> lista = (List<Registro>)request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div align="center" style="border: 2px solid black;">
             
             <p>SEGUNDO PARCIAL TEM-742</p>
             <p>Nombre Boris Huanca Tipola</p> 
          <p>Carnet 9172376</p>
             
          </div>
        <h1 style="text-align:center; "> Registro de Seminarios</h1>
        <p style="text-align:center" >
            <a  href="MainController?op=nuevo">Nuevo</a>
            
        </p>
        <table border ="1" style="margin: 0 auto;">
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Expositor</th>
                <th>Fecha</th>
                 <th>Horario</th>
                <th>Cupos</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${lista}">
                <tr>
                <td>${item.id}</td>
                <td>${item.titulo}</td>
                <td>${item.expositor}</td>
                <td>${item.fecha}</td>
                <td>${item.hora}</td>
                <td>${item.cupos}</td>
                <td><a href="MainController?op=editar&id=${item.id}">Editar</a></td>
                <td><a href="MainController?op=eliminar&id=${item.id}" onclick="return(confirm('ESTA SEGURO DE ELIMINAR?'))">Eliminar</a></td>
            </tr>
            </c:forEach>   
        </table>
    </body>
</html>
