package com.dawidrichert.models;

public class PracaItem {

    private String miesiac;
    private double brutto;
    private double emerytalne;
    private double rentowe;
    private double chorobowe;
    private double zdrowotne;
    private double podstawaOpodatkowania;
    private double zaliczkaPIT;
    private double netto;

    public PracaItem() { }

    public PracaItem(String miesiac, double brutto, double emerytalne, double rentowe, double chorobowe,
                     double zdrowotne, double podstawaOpodatkowania, double zaliczkaPIT, double netto) {
        this.miesiac = miesiac;
        this.brutto = brutto;
        this.emerytalne = emerytalne;
        this.rentowe = rentowe;
        this.chorobowe = chorobowe;
        this.zdrowotne = zdrowotne;
        this.podstawaOpodatkowania = podstawaOpodatkowania;
        this.zaliczkaPIT = zaliczkaPIT;
        this.netto = netto;
    }

    public String getMiesiac() {
        return miesiac;
    }

    public void setMiesiac(String miesiac) {
        this.miesiac = miesiac;
    }

    public double getBrutto() {
        return brutto;
    }

    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }

    public double getEmerytalne() {
        return emerytalne;
    }

    public void setEmerytalne(double emerytalne) {
        this.emerytalne = emerytalne;
    }

    public double getRentowe() {
        return rentowe;
    }

    public void setRentowe(double rentowe) {
        this.rentowe = rentowe;
    }

    public double getChorobowe() {
        return chorobowe;
    }

    public void setChorobowe(double chorobowe) {
        this.chorobowe = chorobowe;
    }

    public double getZdrowotne() {
        return zdrowotne;
    }

    public void setZdrowotne(double zdrowotne) {
        this.zdrowotne = zdrowotne;
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
