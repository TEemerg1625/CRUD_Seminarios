package com.emergentes.modelo;

public class Registro {
    private int id;
    private String titulo;
    private String expositor;
    private String fecha;
    private String hora;
    private int cupos;

    public Registro() {
        this.id = 0;
        this.titulo = "";
        this.expositor ="";
        this.fecha ="";
        this.hora ="";
        this.cupos = 0;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getExpositor() {
        return expositor;
    }

    public void setExpositor(String expositor) {
        this.expositor = expositor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    @Override
    public String toString() {
        return "Registro{" + "id=" + id + ", titulo=" + titulo + ", expositor=" + expositor + ", fecha=" + fecha + ", hora=" + hora + ", cupos=" + cupos + '}';
    }
    
    
    
    
}
