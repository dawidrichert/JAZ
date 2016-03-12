package com.dawidrichert.services;

import com.dawidrichert.enums.InstallmentsType;
import com.dawidrichert.models.CreditData;
import com.dawidrichert.models.PaymentsScheduleItem;

import java.util.ArrayList;
import java.util.List;

public class CreditService {

    public List<PaymentsScheduleItem> calculate(CreditData creditData) {
        if(InstallmentsType.DECREASING.equals(creditData.getInstallmentsType())) {
            return calculateDecreasingCreditInstallment(
                    creditData.getRequestedCreditAmount(),
                    creditData.getInstallmentsNumber(),
                    creditData.getRateOfInterest(),
                    creditData.getFixedFee());
        } else {
            return calculateConstantCreditInstallment(
                    creditData.getRequestedCreditAmount(),
                    creditData.getInstallmentsNumber(),
                    creditData.getRateOfInterest(),
                    creditData.getFixedFee());
        }
    }

    private List<PaymentsScheduleItem> calculateDecreasingCreditInstallment(double creditAmount, int installmentsNumber, double rateOfInterest, double fixedFee) {
        double s = rateOfInterest * 0.01;
        double balance = creditAmount;

        List<PaymentsScheduleItem> paymentsScheduleList = new ArrayList<>();
        for (int i = 0; i < installmentsNumber; i++) {

            double d1 = (( ( (balance * s) * ( installmentsNumber / 12 ) ) + creditAmount) / installmentsNumber);
            double d2 = ( creditAmount / installmentsNumber);
            double d3 = ( d1 - d2 );
            balance -= d2;

            PaymentsScheduleItem paymentsScheduleItem = new PaymentsScheduleItem();
            paymentsScheduleItem.setInstallmentNumber(i+1);
            paymentsScheduleItem.setCapitalAmount(roundDouble(d2));
            paymentsScheduleItem.setInterestAmount(roundDouble(d3));
            paymentsScheduleItem.setFixedFee(fixedFee);
            paymentsScheduleItem.setTotalPaymentsAmount(roundDouble(d1 + fixedFee));

            paymentsScheduleList.add(paymentsScheduleItem);
        }

        return paymentsScheduleList;
    }

    private List<PaymentsScheduleItem> calculateConstantCreditInstallment(double creditAmount, int installmentsNumber, double rateOfInterest, double fixedFee) {
        double s = rateOfInterest * 0.01;

        double ll = calculateInstallment(creditAmount, installmentsNumber, s);
        double capital = creditAmount;

        List<PaymentsScheduleItem> paymentsScheduleList = new ArrayList<>();
        for (int i = 0; i < installmentsNumber; i++) {

            double odsetki = capital * s / 12;
            double czesc = ll - odsetki;
            capital = capital - ll + odsetki;

            PaymentsScheduleItem paymentsScheduleItem = new PaymentsScheduleItem();
            paymentsScheduleItem.setInstallmentNumber(i+1);
            paymentsScheduleItem.setCapitalAmount(roundDouble(czesc));
            paymentsScheduleItem.setInterestAmount(roundDouble(odsetki));
            paymentsScheduleItem.setFixedFee(fixedFee);
            paymentsScheduleItem.setTotalPaymentsAmount(roundDouble(ll + fixedFee));

            paymentsScheduleList.add(paymentsScheduleItem);
        }

        return paymentsScheduleList;
    }

    private double roundDouble(double variable) {
        return Math.round(variable * 100.0) / 100.0;
    }

    private double calculateInstallment(double creditAmount, int installmentsNumber, double rateOfInterest){
        double q1 = rateOfInterest / 12;
        double q2 = 1;

        for (int i = 0 ; i < installmentsNumber ; i++){
            q2 = q2 * (1 + q1);
        }
        return creditAmount * q2 * q1 /(q2 - 1);
    }
}
