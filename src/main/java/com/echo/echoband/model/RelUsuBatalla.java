package com.echo.echoband.model;

public class RelUsuBatalla {
    private int idUsuBat;
    private int idUsuario;
    private int idBatalla;

    public RelUsuBatalla(int idUsuBat, int idUsuario, int idBatalla) {
        this.idUsuBat = idUsuBat;
        this.idUsuario = idUsuario;
        this.idBatalla = idBatalla;
    }

    public int getIdUsuBat() {
        return idUsuBat;
    }

    public void setIdUsuBat(int idUsuBat) {
        this.idUsuBat = idUsuBat;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdBatalla() {
        return idBatalla;
    }

    public void setIdBatalla(int idBatalla) {
        this.idBatalla = idBatalla;
    }
}

