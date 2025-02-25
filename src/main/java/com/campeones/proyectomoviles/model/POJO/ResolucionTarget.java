package com.campeones.proyectomoviles.model.POJO;

//Fill the () with resolutions
public enum ResolucionTarget {
    HD(80),
    FULLHD(120),
    FULLHDPLUS(120),
    QHD(160),
    UHD(240),
    ;
    private int calculo;

    ResolucionTarget(int calculo) {
        this.calculo = calculo;
    }

    public int getCalculo() {
        return calculo;
    }
}
