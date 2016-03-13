package com.dawidrichert.servlets;

import com.dawidrichert.models.CreditData;
import com.dawidrichert.models.PaymentsScheduleItem;
import com.dawidrichert.services.CreditCalculationService;
import com.dawidrichert.services.PdfService;
import com.dawidrichert.utils.RequestMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pdf")
public class PdfServlet extends HttpServlet {

    CreditCalculationService creditCalculationService = new CreditCalculationService();
    PdfService pdfService = new PdfService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreditData creditData = RequestMapper.mapToCreditData(req);
        List<PaymentsScheduleItem> paymentsScheduleItems = creditCalculationService.calculate(creditData);
        pdfService.generate(resp, paymentsScheduleItems);
    }
}