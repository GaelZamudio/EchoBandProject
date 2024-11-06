package com.echo.echoband.model;

import java.time.LocalDateTime;

public class Estadistica {
    private int idEstad;
    private int estrellas;
    private int rango;
    private int medallas;
    private int nivel;
    private int dificultadEsta;
    private LocalDateTime fechaEsta;
    private int nivelesConc;
    private String ligaAct;

    public Estadistica(int idEstad, int estrellas, int rango, int medallas, int nivel, int dificultadEsta, LocalDateTime fechaEsta, int nivelesConc, String ligaAct) {
        this.idEstad = idEstad;
        this.estrellas = estrellas;
        this.rango = rango;
        this.medallas = medallas;
        this.nivel = nivel;
        this.dificultadEsta = dificultadEsta;
        this.fechaEsta = fechaEsta;
        this.nivelesConc = nivelesConc;
        this.ligaAct = ligaAct;
    }

    public int getIdEstad() {
        return idEstad;
    }

    public void setIdEstad(int idEstad) {
        this.idEstad = idEstad;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public int getMedallas() {
        return medallas;
    }

    public void setMedallas(int medallas) {
        this.medallas = medallas;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getDificultadEsta() {
        return dificultadEsta;
    }

    public void setDificultadEsta(int dificultadEsta) {
        this.dificultadEsta = dificultadEsta;
    }

    public LocalDateTime getFechaEsta() {
        return fechaEsta;
    }

    public void setFechaEsta(LocalDateTime fechaEsta) {
        this.fechaEsta = fechaEsta;
    }

    public int getNivelesConc() {
        return nivelesConc;
    }

    public void setNivelesConc(int nivelesConc) {
        this.nivelesConc = nivelesConc;
    }

    public String getLigaAct() {
        return ligaAct;
    }

    public void setLigaAct(String ligaAct) {
        this.ligaAct = ligaAct;
    }
}
