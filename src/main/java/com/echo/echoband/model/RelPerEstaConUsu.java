package com.echo.echoband.model;

public class RelPerEstaConUsu {
    private int idPerEstaConUsu;
    private int idDatos;
    private int idEstad;
    private int idUsuario;

    public RelPerEstaConUsu(int idPerEstaConUsu, int idDatos, int idEstad, int idUsuario) {
        this.idPerEstaConUsu = idPerEstaConUsu;
        this.idDatos = idDatos;
        this.idEstad = idEstad;
        this.idUsuario = idUsuario;
    }

    public int getIdPerEstaConUsu() {
        return idPerEstaConUsu;
    }

    public void setIdPerEstaConUsu(int idPerEstaConUsu) {
        this.idPerEstaConUsu = idPerEstaConUsu;
    }

    public int getIdDatos() {
        return idDatos;
    }

    public void setIdDatos(int idDatos) {
        this.idDatos = idDatos;
    }

    public int getIdEstad() {
        return idEstad;
    }

    public void setIdEstad(int idEstad) {
        this.idEstad = idEstad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
