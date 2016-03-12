package com.dawidrichert.models;

import com.dawidrichert.models.enums.InstallmentsType;

public class CreditData {

    private double requestedCreditAmount;
    private int installmentsNumber;
    private double rateOfInterest;
    private double fixedFee;
    private InstallmentsType installmentsType;

    public CreditData() { }

    public CreditData(double requestedCreditAmount, int installmentsNumber, double rateOfInterest, double fixedFee, InstallmentsType installmentsType) {
        this.requestedCreditAmount = requestedCreditAmount;
        this.installmentsNumber = installmentsNumber;
        this.rateOfInterest = rateOfInterest;
        this.fixedFee = fixedFee;
        this.installmentsType = installmentsType;
    }

    public double getRequestedCreditAmount() {
        return requestedCreditAmount;
    }

    public void setRequestedCreditAmount(double requestedCreditAmount) {
        this.requestedCreditAmount = requestedCreditAmount;
    }

    public int getInstallmentsNumber() {
        return installmentsNumber;
    }

    public void setInstallmentsNumber(int installmentsNumber) {
        this.installmentsNumber = installmentsNumber;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public double getFixedFee() {
        return fixedFee;
    }

    public void setFixedFee(double fixedFee) {
        this.fixedFee = fixedFee;
    }

    public InstallmentsType getInstallmentsType() {
        return installmentsType;
    }

    public void setInstallmentsType(InstallmentsType installmentsType) {
        this.installmentsType = installmentsType;
    }
}
