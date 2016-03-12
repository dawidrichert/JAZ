package com.dawidrichert.servlets;

import com.dawidrichert.models.CreditData;
import com.dawidrichert.models.PaymentsScheduleItem;
import com.dawidrichert.services.CreditService;
import com.dawidrichert.utils.Mapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/harmonogram")
public class CalculateServlet extends HttpServlet {

    CreditService creditService = new CreditService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreditData creditData = Mapper.mapRequestToCreditData(req);
        List<PaymentsScheduleItem> paymentsScheduleItems = creditService.calculate(creditData);
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
