package com.echo.echoband.model;

public class RelLogEstadistica {
    private int idLogEst;
    private int idEstad;
    private int idLogro;

    public RelLogEstadistica(int idLogEst, int idEstad, int idLogro) {
        this.idLogEst = idLogEst;
        this.idEstad = idEstad;
        this.idLogro = idLogro;
    }

    public int getIdLogEst() {
        return idLogEst;
    }

    public void setIdLogEst(int idLogEst) {
        this.idLogEst = idLogEst;
    }

    public int getIdEstad() {
        return idEstad;
    }

    public void setIdEstad(int idEstad) {
        this.idEstad = idEstad;
    }

    public int getIdLogro() {
        return idLogro;
    }

    public void setIdLogro(int idLogro) {
        this.idLogro = idLogro;
    }
}
