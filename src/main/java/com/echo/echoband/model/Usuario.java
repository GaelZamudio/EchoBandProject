package com.echo.echoband.model;

public class Usuario {
    private int idUsuario;
    private byte[] foto;
    private String nomUsuario;

    public Usuario(int idUsuario, byte[] foto, String nomUsuario) {
        this.idUsuario = idUsuario;
        this.foto = foto;
        this.nomUsuario = nomUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }
}
