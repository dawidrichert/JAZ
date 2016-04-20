package com.dawidrichert.models;

import com.dawidrichert.models.enums.ContractType;
import com.dawidrichert.models.enums.DeductibleCosts;
import com.dawidrichert.models.enums.PayType;

public class CalculationData {

    private ContractType contractType;
    private int year;
    private double salary;
    private PayType payType;
    private boolean disabilityContribution;
    private boolean pensionContribution;
    private boolean sicknessContribution;
    private boolean healthCareContribution;
    private DeductibleCosts deductibleCosts;

    public static final String contractTypeKey = "contractType";
    public static final String yearKey = "year";
    public static final String salaryKey = "salary";
    public static final String payTypeKey = "payType";
    public static final String disabilityContributionKey = "disabilityContribution";
    public static final String pensionContributionKey = "pensionContribution";
    public static final String sicknessContributionKey = "sicknessContribution";
    public static final String healthCareContributionKey = "healthCareContribution";
    public static final String deductibleCostsKey = "deductibleCosts";

    public CalculationData(ContractType contractType, int year, double salary, PayType payType,
                           boolean disabilityContribution, boolean pensionContribution, boolean sicknessContribution,
                           boolean healthCareContribution, DeductibleCosts deductibleCosts) {
        this.contractType = contractType;
        this.year = year;
        this.salary = salary;
        this.payType = payType;
        this.disabilityContribution = disabilityContribution;
        this.pensionContribution = pensionContribution;
        this.sicknessContribution = sicknessContribution;
        this.healthCareContribution = healthCareContribution;
        this.deductibleCosts = deductibleCosts;
    }

    public DeductibleCosts getDeductibleCosts() {
        return deductibleCosts;
    }

    public void setDeductibleCosts(DeductibleCosts deductibleCosts) {
        this.deductibleCosts = deductibleCosts;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public boolean isDisabilityContribution() {
        return disabilityContribution;
    }

    public void setDisabilityContribution(boolean disabilityContribution) {
        this.disabilityContribution = disabilityContribution;
    }

    public boolean isPensionContribution() {
        return pensionContribution;
    }

    public void setPensionContribution(boolean pensionContribution) {
        this.pensionContribution = pensionContribution;
    }

    public boolean isSicknessContribution() {
        return sicknessContribution;
    }

    public void setSicknessContribution(boolean sicknessContribution) {
        this.sicknessContribution = sicknessContribution;
    }

    public boolean isHealthCareContribution() {
        return healthCareContribution;
    }

    public void setHealthCareContribution(boolean healthCareContribution) {
        this.healthCareContribution = healthCareContribution;
    }
}
