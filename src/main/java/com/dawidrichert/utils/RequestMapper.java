package com.dawidrichert.utils;

import com.dawidrichert.models.enums.InstallmentsType;
import com.dawidrichert.models.CreditData;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;

public class RequestMapper {

    public static CreditData mapToCreditData(HttpServletRequest req) {
        try {
            return new CreditData(
                    ServletRequestUtils.getDoubleParameter(req, CreditData.requestedCreditAmountKey),
                    ServletRequestUtils.getIntParameter(req, CreditData.installmentsNumberKey),
                    ServletRequestUtils.getDoubleParameter(req, CreditData.rateOfInterestKey),
                    ServletRequestUtils.getDoubleParameter(req, CreditData.fixedFeeKey),
                    InstallmentsType.values()[ServletRequestUtils.getIntParameter(req, CreditData.installmentsTypeKey)]);
        } catch (ServletRequestBindingException e) {
            return null;
        }
    }
}
