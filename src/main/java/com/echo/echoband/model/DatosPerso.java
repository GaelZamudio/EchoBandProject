package com.echo.echoband.model;

public class DatosPerso {
    private int idDatos;
    private String nomReal;
    private String nomUsuario;
    private String apPat;
    private String apMat;
    private String contraseña;
    private String correo;

    public DatosPerso(int idDatos, String nomReal, String nomUsuario, String apPat, String apMat, String contraseña, String correo) {
        this.idDatos = idDatos;
        this.nomReal = nomReal;
        this.nomUsuario = nomUsuario;
        this.apPat = apPat;
        this.apMat = apMat;
        this.contraseña = contraseña;
        this.correo = correo;
    }

    public int getIdDatos() {
        return idDatos;
    }

    public void setIdDatos(int idDatos) {
        this.idDatos = idDatos;
    }

    public String getNomReal() {
        return nomReal;
    }

    public void setNomReal(String nomReal) {
        this.nomReal = nomReal;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getApPat() {
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
