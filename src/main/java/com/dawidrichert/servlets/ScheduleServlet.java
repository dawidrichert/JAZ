package com.dawidrichert.servlets;

import com.dawidrichert.models.CreditData;
import com.dawidrichert.models.PaymentsScheduleItem;
import com.dawidrichert.services.CreditCalculationService;
import com.dawidrichert.utils.RequestMapper;
import com.dawidrichert.utils.Resources;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/harmonogram")
public class ScheduleServlet extends HttpServlet {

    CreditCalculationService creditCalculationService = new CreditCalculationService();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreditData creditData = RequestMapper.mapToCreditData(req);
        if(creditData == null) {
            req.setAttribute("error", true);
            req.getRequestDispatcher(Resources.IndexJsp).forward(req, resp);
            return;
        }
        List<PaymentsScheduleItem> paymentsScheduleItems = creditCalculationService.calculate(creditData);
        forwardPaymentsSchedule(req, resp, paymentsScheduleItems);
    }

    private void forwardPaymentsSchedule(HttpServletRequest req, HttpServletResponse resp, List paymentsScheduleItems)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(Resources.PaymentsScheduleJsp);
        req.setAttribute("paymentsScheduleList", paymentsScheduleItems);
        dispatcher.forward(req, resp);
    }
}
