package com.echo.echoband.model;

public class RelUsuarioEntrenamiento {
    private int idRelUsuEntr;
    private int idUsuario;
    private int idEntrenamiento;

    public RelUsuarioEntrenamiento(int idRelUsuEntr, int idUsuario, int idEntrenamiento) {
        this.idRelUsuEntr = idRelUsuEntr;
        this.idUsuario = idUsuario;
        this.idEntrenamiento = idEntrenamiento;
    }

    public int getIdRelUsuEntr() {
        return idRelUsuEntr;
    }

    public void setIdRelUsuEntr(int idRelUsuEntr) {
        this.idRelUsuEntr = idRelUsuEntr;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEntrenamiento() {
        return idEntrenamiento;
    }

    public void setIdEntrenamiento(int idEntrenamiento) {
        this.idEntrenamiento = idEntrenamiento;
    }
}

