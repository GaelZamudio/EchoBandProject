package com.echo.echoband.model;

public class Desafio {
    private int idDesafio;
    private String descDesa;
    private String dificultadDesa;
    private int duracDesa;

    public Desafio(int idDesafio, String descDesa, String dificultadDesa, int duracDesa) {
        this.idDesafio = idDesafio;
        this.descDesa = descDesa;
        this.dificultadDesa = dificultadDesa;
        this.duracDesa = duracDesa;
    }

    public int getIdDesafio() {
        return idDesafio;
    }

    public void setIdDesafio(int idDesafio) {
        this.idDesafio = idDesafio;
    }

    public String getDescDesa() {
        return descDesa;
    }

    public void setDescDesa(String descDesa) {
        this.descDesa = descDesa;
    }

    public String getDificultadDesa() {
        return dificultadDesa;
    }

    public void setDificultadDesa(String dificultadDesa) {
        this.dificultadDesa = dificultadDesa;
    }

    public int getDuracDesa() {
        return duracDesa;
    }

    public void setDuracDesa(int duracDesa) {
        this.duracDesa = duracDesa;
    }
}

