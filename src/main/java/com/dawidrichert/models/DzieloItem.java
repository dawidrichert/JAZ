package com.dawidrichert.models;

public class DzieloItem {

    private double brutto;
    private double kosztUzyskaniaPrzychodu;
    private double podstawaOpodatkowania;
    private double zaliczkaPIT;
    private double netto;

    public DzieloItem(double brutto, double kosztUzyskaniaPrzychodu, double podstawaOpodatkowania, double zaliczkaPIT,
                      double netto) {
        this.brutto = brutto;
        this.kosztUzyskaniaPrzychodu = kosztUzyskaniaPrzychodu;
        this.podstawaOpodatkowania = podstawaOpodatkowania;
        this.zaliczkaPIT = zaliczkaPIT;
        this.netto = netto;
    }

    public double getBrutto() {
        return brutto;
    }

    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }

    public double getKosztUzyskaniaPrzychodu() {
        return kosztUzyskaniaPrzychodu;
    }

    public void setKosztUzyskaniaPrzychodu(double kosztUzyskaniaPrzychodu) {
        this.kosztUzyskaniaPrzychodu = kosztUzyskaniaPrzychodu;
    }

    public double getPodstawaOpodatkowania() {
        return podstawaOpodatkowania;
    }

    public void setPodstawaOpodatkowania(double podstawaOpodatkowania) {
        this.podstawaOpodatkowania = podstawaOpodatkowania;
    }

    public double getZaliczkaPIT() {
        return zaliczkaPIT;
    }

    public void setZaliczkaPIT(double zaliczkaPIT) {
        this.zaliczkaPIT = zaliczkaPIT;
    }

    public double getNetto() {
        return netto;
    }

    public void setNetto(double netto) {
        this.netto = netto;
    }
}
