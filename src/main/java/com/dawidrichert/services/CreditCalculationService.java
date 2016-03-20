//package com.dawidrichert.services;
//
//import com.dawidrichert.models.enums.InstallmentsType;
//import com.dawidrichert.models.CreditData;
//import com.dawidrichert.models.PaymentsScheduleItem;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CreditCalculationService {
//
//    public List<PaymentsScheduleItem> calculate(CreditData creditData) {
//        if (InstallmentsType.DECREASING.equals(creditData.getInstallmentsType())) {
//            return calculateDecreasingCreditInstallment(creditData);
//        } else {
//            return calculateConstantCreditInstallment(creditData);
//        }
//    }
//
//    private List<PaymentsScheduleItem> calculateDecreasingCreditInstallment(CreditData creditData) {
//        double balance = creditData.getRequestedCreditAmount();
//        List<PaymentsScheduleItem> paymentsScheduleList = new ArrayList<>();
//        for (int i = 0; i < creditData.getInstallmentsNumber(); i++) {
//
//            double d1 = ((((balance * creditData.getRateOfInterest() * 0.01) * (creditData.getInstallmentsNumber() / 12)) + creditData.getRequestedCreditAmount()) / creditData.getInstallmentsNumber());
//            double d2 = (creditData.getRequestedCreditAmount() / creditData.getInstallmentsNumber());
//            double d3 = (d1 - d2);
//            balance -= d2;
//
//            PaymentsScheduleItem paymentsScheduleItem = new PaymentsScheduleItem();
//            paymentsScheduleItem.setInstallmentNumber(i + 1);
//            paymentsScheduleItem.setCapitalAmount(d2);
//            paymentsScheduleItem.setInterestAmount(d3);
//            paymentsScheduleItem.setFixedFee(creditData.getFixedFee());
//            paymentsScheduleItem.setTotalPaymentsAmount(d1 + creditData.getFixedFee());
//
//            paymentsScheduleList.add(paymentsScheduleItem);
//        }
//
//        return paymentsScheduleList;
//    }
//
//    private List<PaymentsScheduleItem> calculateConstantCreditInstallment(CreditData creditData) {
//        double installment = calculateInstallment(creditData.getRequestedCreditAmount(), creditData.getInstallmentsNumber(), creditData.getRateOfInterest());
//        double capital = creditData.getRequestedCreditAmount();
//
//        List<PaymentsScheduleItem> paymentsScheduleList = new ArrayList<>();
//        for (int i = 0; i < creditData.getInstallmentsNumber(); i++) {
//
//            double interest = capital * creditData.getRateOfInterest() * 0.01 / 12;
//            capital = capital - installment + interest;
//
//            PaymentsScheduleItem paymentsScheduleItem = new PaymentsScheduleItem();
//            paymentsScheduleItem.setInstallmentNumber(i + 1);
//            paymentsScheduleItem.setCapitalAmount(installment - interest);
//            paymentsScheduleItem.setInterestAmount(interest);
//            paymentsScheduleItem.setFixedFee(creditData.getFixedFee());
//            paymentsScheduleItem.setTotalPaymentsAmount(installment + creditData.getFixedFee());
//
//            paymentsScheduleList.add(paymentsScheduleItem);
//        }
//
//        return paymentsScheduleList;
//    }
//
//    private double calculateInstallment(double creditAmount, int installmentsNumber, double rateOfInterest) {
//        double q1 = rateOfInterest * 0.01 / 12;
//        double q2 = 1;
//
//        for (int i = 0; i < installmentsNumber; i++) {
//            q2 = q2 * (1 + q1);
//        }
//        return creditAmount * q2 * q1 / (q2 - 1);
//    }
//}
