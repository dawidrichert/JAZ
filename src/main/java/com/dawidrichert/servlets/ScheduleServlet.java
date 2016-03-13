package com.dawidrichert.servlets;

import com.dawidrichert.models.CreditData;
import com.dawidrichert.models.PaymentsScheduleItem;
import com.dawidrichert.services.CreditCalculationService;
import com.dawidrichert.utils.RequestMapper;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreditData creditData = RequestMapper.mapToCreditData(req);
        if(creditData == null) {
            req.setAttribute("error", true);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("message", null);
        List<PaymentsScheduleItem> paymentsScheduleItems = creditCalculationService.calculate(creditData);
        forwardPaymentsSchedule(req, resp, paymentsScheduleItems);
    }

    private void forwardPaymentsSchedule(HttpServletRequest req, HttpServletResponse resp, List paymentsScheduleItems)
            throws ServletException, IOException {
        String nextJSP = "/jsp/paymentsSchedule.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("paymentsScheduleList", paymentsScheduleItems);
        dispatcher.forward(req, resp);
    }
}
