package com.echo.echoband.model;

import java.time.LocalDate;

public class Entrenamiento {
    private int idEntrenamiento;
    private LocalDate fecha;
    private int numeroNivel;
    private String dificultad;
    private String tipo;
    private int estrellas;
    private int numeroEntrenamiento;

    public Entrenamiento(int idEntrenamiento, LocalDate fecha, int numeroNivel, String dificultad, String tipo, int estrellas, int numeroEntrenamiento) {
        this.idEntrenamiento = idEntrenamiento;
        this.fecha = fecha;
        this.numeroNivel = numeroNivel;
        this.dificultad = dificultad;
        this.tipo = tipo;
        this.estrellas = estrellas;
        this.numeroEntrenamiento = numeroEntrenamiento;
    }

    public int getIdEntrenamiento() {
        return idEntrenamiento;
    }

    public void setIdEntrenamiento(int idEntrenamiento) {
        this.idEntrenamiento = idEntrenamiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getNumeroNivel() {
        return numeroNivel;
    }

    public void setNumeroNivel(int numeroNivel) {
        this.numeroNivel = numeroNivel;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public int getNumeroEntrenamiento() {
        return numeroEntrenamiento;
    }

    public void setNumeroEntrenamiento(int numeroEntrenamiento) {
        this.numeroEntrenamiento = numeroEntrenamiento;
    }
}
