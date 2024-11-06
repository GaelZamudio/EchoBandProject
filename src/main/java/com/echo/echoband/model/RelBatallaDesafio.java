package com.echo.echoband.model;

public class RelBatallaDesafio {
    private int idBatDesa;
    private int idBatalla;
    private int idDesafio;

    public RelBatallaDesafio(int idBatDesa, int idBatalla, int idDesafio) {
        this.idBatDesa = idBatDesa;
        this.idBatalla = idBatalla;
        this.idDesafio = idDesafio;
    }

    public int getIdBatDesa() {
        return idBatDesa;
    }

    public void setIdBatDesa(int idBatDesa) {
        this.idBatDesa = idBatDesa;
    }

    public int getIdBatalla() {
        return idBatalla;
    }

    public void setIdBatalla(int idBatalla) {
        this.idBatalla = idBatalla;
    }

    public int getIdDesafio() {
        return idDesafio;
    }

    public void setIdDesafio(int idDesafio) {
        this.idDesafio = idDesafio;
    }
}

