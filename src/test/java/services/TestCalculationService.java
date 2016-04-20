package services;

import com.dawidrichert.models.CalculationData;
import com.dawidrichert.models.DzieloItem;
import com.dawidrichert.models.PracaItem;
import com.dawidrichert.models.ZlecenieItem;
import com.dawidrichert.models.enums.ContractType;
import com.dawidrichert.models.enums.DeductibleCosts;
import com.dawidrichert.models.enums.PayType;
import com.dawidrichert.services.CalculationService;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TestCalculationService extends Mockito {

    @Test
    public void calculate_ShouldReturn_PracaItems_When_ContractTypeIs_PRACA() {
        CalculationService calculationService = new CalculationService();
        CalculationData calculationData = new CalculationData(ContractType.PRACA, 2016, 2000,
                PayType.BRUTTO, false, false, false, false, DeductibleCosts.PERCENT_20);

        List creditData = calculationService.calculate(calculationData);

        assertTrue(creditData.get(0) instanceof PracaItem);
    }

    @Test
    public void calculate_ShouldReturn_ZlecenieItems_When_ContractTypeIs_ZLECENIE() {
        CalculationService calculationService = new CalculationService();
        CalculationData calculationData = new CalculationData(ContractType.ZLECENIE, 2016, 2000,
                PayType.BRUTTO, false, false, false, false, DeductibleCosts.PERCENT_20);

        List creditData = calculationService.calculate(calculationData);

        assertTrue(creditData.get(0) instanceof ZlecenieItem);
    }

    @Test
    public void calculate_ShouldReturn_DzieloItems_When_ContractTypeIs_DZIELO() {
        CalculationService calculationService = new CalculationService();
        CalculationData calculationData = new CalculationData(ContractType.DZIELO, 2016, 2000,
                PayType.BRUTTO, false, false, false, false, DeductibleCosts.PERCENT_20);

        List creditData = calculationService.calculate(calculationData);

        assertTrue(creditData.get(0) instanceof DzieloItem);
    }

    @Test
    public void calculate_ShouldReturn_12_Records_When_ContractTypeIs_PRACA() {
        CalculationService calculationService = new CalculationService();
        CalculationData calculationData = new CalculationData(ContractType.PRACA, 2016, 2000,
                PayType.BRUTTO, false, false, false, false, DeductibleCosts.PERCENT_20);

        List creditData = calculationService.calculate(calculationData);

        assertEquals(12, creditData.size());
    }

    @Test
    public void calculate_ShouldReturn_1_Record_When_ContractTypeIs_ZLECENIE() {
        CalculationService calculationService = new CalculationService();
        CalculationData calculationData = new CalculationData(ContractType.ZLECENIE, 2016, 2000,
                PayType.BRUTTO, false, false, false, false, DeductibleCosts.PERCENT_20);

        List creditData = calculationService.calculate(calculationData);

        assertEquals(1, creditData.size());
    }

    @Test
    public void calculate_ShouldReturn_1_Record_When_ContractTypeIs_DZIELO() {
        CalculationService calculationService = new CalculationService();
        CalculationData calculationData = new CalculationData(ContractType.DZIELO, 2016, 2000,
                PayType.BRUTTO, false, false, false, false, DeductibleCosts.PERCENT_20);

        List creditData = calculationService.calculate(calculationData);

        assertEquals(1, creditData.size());
    }
}
