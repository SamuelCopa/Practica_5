package com.emergentes.modelo;

public class Usuario {

    private int id;
    private String usuario;
    private String contraseña;

    public Usuario() {
        this.id=0;
        this.usuario="";
        this.contraseña="";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }    

}
