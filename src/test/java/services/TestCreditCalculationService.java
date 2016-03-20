//package services;
//
//import com.dawidrichert.models.CreditData;
//import com.dawidrichert.models.PaymentsScheduleItem;
//import com.dawidrichert.models.enums.InstallmentsType;
//import com.dawidrichert.services.CreditCalculationService;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import java.util.List;
//
//import static junit.framework.TestCase.assertEquals;
//
//public class TestCreditCalculationService {
//
//    @Test
//    public void calculate_ShouldReturn_TheSameNumberOfPaymentsScheduleItems_AsInstallmentsNumber() {
//        CreditCalculationService creditCalculationService = new CreditCalculationService();
//        CreditData creditData = new CreditData(200000, 360, 7.5, 0, InstallmentsType.CONSTANT);
//
//        List<PaymentsScheduleItem> result = creditCalculationService.calculate(creditData);
//
//        assertEquals(creditData.getInstallmentsNumber(), result.size());
//    }
//
//    @Test
//    public void calculate_ShouldReturn_CorrectCalculationResults_ForConstantInstallments() {
//        CreditCalculationService creditCalculationService = new CreditCalculationService();
//        CreditData creditData = new CreditData(200000, 360, 7.5, 0, InstallmentsType.CONSTANT);
//
//        List<PaymentsScheduleItem> result = creditCalculationService.calculate(creditData);
//        PaymentsScheduleItem firstElement = result.get(0);
//        PaymentsScheduleItem lastElement = result.get(result.size()-1);
//
//        // First element
//        assertEquals(1, firstElement.getInstallmentNumber());
//        assertEquals(148.43, firstElement.getCapitalAmount());
//        assertEquals(1250.0, firstElement.getInterestAmount());
//        assertEquals(0.0, firstElement.getFixedFee());
//        assertEquals(1398.43, firstElement.getTotalPaymentsAmount());
//        // Last element
//        assertEquals(360, lastElement.getInstallmentNumber());
//        assertEquals(1389.74, lastElement.getCapitalAmount());
//        assertEquals(8.69, lastElement.getInterestAmount());
//        assertEquals(0.0, lastElement.getFixedFee());
//        assertEquals(1398.43, lastElement.getTotalPaymentsAmount());
//    }
//
//    @Test
//    public void calculate_ShouldReturn_CorrectCalculationResults_ForDecreasingInstallments() {
//        CreditCalculationService creditCalculationService = new CreditCalculationService();
//        CreditData creditData = new CreditData(200000, 360, 7.5, 0, InstallmentsType.DECREASING);
//
//        List<PaymentsScheduleItem> result = creditCalculationService.calculate(creditData);
//        PaymentsScheduleItem firstElement = result.get(0);
//        PaymentsScheduleItem lastElement = result.get(result.size()-1);
//
//        // First element
//        assertEquals(1, firstElement.getInstallmentNumber());
//        assertEquals(555.56, firstElement.getCapitalAmount());
//        assertEquals(1250.0, firstElement.getInterestAmount());
//        assertEquals(0.0, firstElement.getFixedFee());
//        assertEquals(1805.56, firstElement.getTotalPaymentsAmount());
//        // Last element
//        assertEquals(360, lastElement.getInstallmentNumber());
//        assertEquals(555.56, lastElement.getCapitalAmount());
//        assertEquals(3.47, lastElement.getInterestAmount());
//        assertEquals(0.0, lastElement.getFixedFee());
//        assertEquals(559.03, lastElement.getTotalPaymentsAmount());
//    }
//}
