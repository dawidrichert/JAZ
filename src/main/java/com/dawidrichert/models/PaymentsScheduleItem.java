package com.dawidrichert.models;

public class PaymentsScheduleItem {

    private int installmentNumber;
    private double capitalAmount;
    private double interestAmount;
    private double fixedFee;
    private double totalPaymentsAmount;

    public PaymentsScheduleItem() { }

    public PaymentsScheduleItem(int installmentNumber, double capitalAmount, double interestAmount, double fixedFee, double totalPaymentsAmount) {
        this.installmentNumber = installmentNumber;
        this.capitalAmount = capitalAmount;
        this.interestAmount = interestAmount;
        this.fixedFee = fixedFee;
        this.totalPaymentsAmount = totalPaymentsAmount;
    }

    public int getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(int installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public double getCapitalAmount() {
        return capitalAmount;
    }

    public void setCapitalAmount(double capitalAmount) {
        this.capitalAmount = capitalAmount;
    }

    public double getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(double interestAmount) {
        this.interestAmount = interestAmount;
    }

    public double getFixedFee() {
        return fixedFee;
    }

    public void setFixedFee(double fixedFee) {
        this.fixedFee = fixedFee;
    }

    public double getTotalPaymentsAmount() {
        return totalPaymentsAmount;
    }

    public void setTotalPaymentsAmount(double totalPaymentsAmount) {
        this.totalPaymentsAmount = totalPaymentsAmount;
    }
}
