
package com.emergentes.controlador;

import com.emergentes.modelo.Registro;
import com.emergentes.utiles.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PreparedStatement ps;
        ConexionDB canal = new ConexionDB();
        Connection conn =  canal.conectar();
        ResultSet rs;
        String op;
        ArrayList<Registro> lista = new ArrayList<Registro>();
        int id;
        op = (request.getParameter("op")!=null) ? request.getParameter("op"):"list";
        if(op.equals("list")){
            //OPERACIONES PARA LISTAR DATOS
         String sql = "select * from seminarios";
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    Registro reg = new Registro();
                    
                    reg.setId(rs.getInt("id"));
                    reg.setTitulo(rs.getString("titulo"));
                    reg.setExpositor(rs.getString("expositor"));
                    reg.setFecha(rs.getString("fecha"));
                    reg.setHora(rs.getString("hora"));
                    reg.setCupos(rs.getInt("cupo" ));
                    
                    lista.add(reg);    
                }
                request.setAttribute("lista",lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        if(op.equals("nuevo")){
            //OPERACIONES PARA DESPLEGAR FORMULARIO
            
            Registro  re = new Registro();
            
            request.setAttribute("reg", re);
            request.getRequestDispatcher("editar.jsp").forward(request, response);

        }
        if(op.equals("editar")){
            id = Integer.parseInt(request.getParameter("id"));
            
            try {
                Registro reg1 = new Registro();
                ps = conn.prepareStatement("select * from seminarios where id =?");
                ps.setInt(1, id);
                ps.executeQuery();
                rs  = ps.executeQuery();
                
                if(rs.next()){
                    reg1.setId(rs.getInt("id"));
                    reg1.setTitulo(rs.getString("titulo"));
                    reg1.setExpositor(rs.getString("expositor"));
                    reg1.setFecha(rs.getString("fecha"));
                    reg1.setHora(rs.getString("hora"));
                    reg1.setCupos(rs.getInt("cupo"));

                }
                request.setAttribute("reg", reg1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(op.equals("eliminar")){
            //OPERACIONES PAR ELIMINAR REGISTRO
            id = Integer.parseInt(request.getParameter("id"));
            
            try {
                ps = conn.prepareStatement("delete from seminarios where id = ?");
                ps.setInt(1, id);
                
                ps.executeUpdate();
                response.sendRedirect("MainController");
                
                
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
    }
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String expositor = request.getParameter("expositor");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        int cupo = Integer.parseInt(request.getParameter("cupo"));
        
        Registro reg = new Registro();
        reg.setId(id);
        reg.setTitulo(titulo);
        reg.setExpositor(expositor);
        reg.setFecha(fecha);
        reg.setHora(hora);
        reg.setCupos(cupo);
        
        ConexionDB canal = new ConexionDB();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
        
        if(id == 0){
            //INSERTAR REGISTRO
            String sql = "insert into seminarios(titulo,expositor,fecha,hora,cupo)values(?,?,?,?,?)";
            
            try {
                ps=conn.prepareStatement(sql);
                ps.setString(1,reg.getTitulo());
                ps.setString(2, reg.getExpositor());
                ps.setString(3, reg.getFecha());
                ps.setString(4, reg.getHora());
                ps.setInt(5, reg.getCupos());
                
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else{
            //UPDATE REGISTRO
            String sql1 = "update seminarios set titulo=?,expositor=?,fecha=?,hora=?,cupo=? where id=?";
            
            try {
                ps = conn.prepareStatement(sql1);
                ps.setString(1, reg.getTitulo());
                ps.setString(2, reg.getExpositor());
                ps.setString(3, reg.getFecha());
                ps.setString(4, reg.getHora());
                ps.setInt(5, reg.getCupos());
                ps.setInt(6, reg.getId());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
       response.sendRedirect("MainController"); 
    }

}
