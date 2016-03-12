package com.dawidrichert.utils;

import com.dawidrichert.enums.InstallmentsType;
import com.dawidrichert.models.CreditData;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;

public class Mapper {

    public static CreditData mapRequestToCreditData(HttpServletRequest req) {
        try {
            return new CreditData(
                    ServletRequestUtils.getDoubleParameter(req, "requestedCreditAmount"),
                    ServletRequestUtils.getIntParameter(req, "installmentsNumber"),
                    ServletRequestUtils.getDoubleParameter(req, "rateOfInterest"),
                    ServletRequestUtils.getDoubleParameter(req, "fixedFee"),
                    InstallmentsType.values()[ServletRequestUtils.getIntParameter(req, "installmentsType")]);
        } catch (ServletRequestBindingException e) {
            return null;
        }
    }
}
