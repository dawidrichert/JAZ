package com.dawidrichert.servlets;

import com.dawidrichert.models.CalculationData;
import com.dawidrichert.models.enums.ContractType;
import com.dawidrichert.services.CalculationService;
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

@WebServlet(Resources.calculateUrl)
public class CalculateServlet extends HttpServlet {

    private final CalculationService calculationService = new CalculationService();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CalculationData calculationData = RequestMapper.mapToCalculationData(req);
        if(calculationData == null) {
            req.setAttribute("error", true);
            req.getRequestDispatcher(Resources.indexJsp).forward(req, resp);
            return;
        }

        ContractType contractType = calculationData.getContractType();
        if(contractType != null) {
            forwardResult(req, resp, calculationService.calculate(calculationData), contractType.toString());
        }
    }

    private void forwardResult(HttpServletRequest req, HttpServletResponse resp, List list, String type)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(Resources.resultJsp);
        req.setAttribute("list", list);
        req.setAttribute("contractType", type);
        dispatcher.forward(req, resp);
    }
}
