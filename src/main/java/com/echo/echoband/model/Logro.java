package com.echo.echoband.model;

import java.time.LocalDateTime;

public class Logro {
    private int idLogro;
    private int porcentajeUsua;
    private String categoria;
    private String descLogr;
    private LocalDateTime fechaLogr;

    public Logro(int idLogro, int porcentajeUsua, String categoria, String descLogr, LocalDateTime fechaLogr) {
        this.idLogro = idLogro;
        this.porcentajeUsua = porcentajeUsua;
        this.categoria = categoria;
        this.descLogr = descLogr;
        this.fechaLogr = fechaLogr;
    }

    public int getIdLogro() {
        return idLogro;
    }

    public void setIdLogro(int idLogro) {
        this.idLogro = idLogro;
    }

    public int getPorcentajeUsua() {
        return porcentajeUsua;
    }

    public void setPorcentajeUsua(int porcentajeUsua) {
        this.porcentajeUsua = porcentajeUsua;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescLogr() {
        return descLogr;
    }

    public void setDescLogr(String descLogr) {
        this.descLogr = descLogr;
    }

    public LocalDateTime getFechaLogr() {
        return fechaLogr;
    }

    public void setFechaLogr(LocalDateTime fechaLogr) {
        this.fechaLogr = fechaLogr;
    }
}
