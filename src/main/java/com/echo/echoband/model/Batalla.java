package com.echo.echoband.model;

import java.time.LocalDateTime;

public class Batalla {
    private int idBatalla;
    private int duractBat;
    private int estrellas;
    private LocalDateTime fechaBata;

    public Batalla(int idBatalla, int duractBat, int estrellas, LocalDateTime fechaBata) {
        this.idBatalla = idBatalla;
        this.duractBat = duractBat;
        this.estrellas = estrellas;
        this.fechaBata = fechaBata;
    }

    public int getIdBatalla() {
        return idBatalla;
    }

    public void setIdBatalla(int idBatalla) {
        this.idBatalla = idBatalla;
    }

    public int getDuractBat() {
        return duractBat;
    }

    public void setDuractBat(int duractBat) {
        this.duractBat = duractBat;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public LocalDateTime getFechaBata() {
        return fechaBata;
    }

    public void setFechaBata(LocalDateTime fechaBata) {
        this.fechaBata = fechaBata;
    }
}

