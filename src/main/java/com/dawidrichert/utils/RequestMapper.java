package com.dawidrichert.utils;

import com.dawidrichert.models.CalculationData;
import com.dawidrichert.models.enums.ContractType;
import com.dawidrichert.models.enums.DeductibleCosts;
import com.dawidrichert.models.enums.PayType;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;

public class RequestMapper {

    public static CalculationData mapToCalculationData(HttpServletRequest req) {
        try {
            return new CalculationData(
                    ContractType.values()[ServletRequestUtils.getIntParameter(req, CalculationData.contractTypeKey)],
                    ServletRequestUtils.getIntParameter(req, CalculationData.yearKey),
                    ServletRequestUtils.getDoubleParameter(req, CalculationData.salaryKey),
                    PayType.values()[ServletRequestUtils.getIntParameter(req, CalculationData.payTypeKey)],
                    ServletRequestUtils.getBooleanParameter(req, CalculationData.disabilityContributionKey),
                    ServletRequestUtils.getBooleanParameter(req, CalculationData.pensionContributionKey),
                    ServletRequestUtils.getBooleanParameter(req, CalculationData.sicknessContributionKey),
                    ServletRequestUtils.getBooleanParameter(req, CalculationData.healthCareContributionKey),
                    DeductibleCosts.values()[ServletRequestUtils.getIntParameter(req, CalculationData.deductibleCostsKey)]);
        } catch (Exception e) {
            return null;
        }
    }
}
