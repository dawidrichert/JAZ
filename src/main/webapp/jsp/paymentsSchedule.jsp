<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Kalkulator rat kredytu</title>
        <link rel="icon" type="image/png" href="../img/favicon.png" />
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <script src="../js/jquery-1.12.1.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>       
    </head>
    <body>          
        <div class="container">
            <h2>Harmonogram spłat</h2>
            </br>
            <form action="/pdf" method="post" id="employeeForm" role="form" >
                <input type="hidden" id="requestedCreditAmount" name="requestedCreditAmount" value="<%= request.getParameter("requestedCreditAmount") %>">
                <input type="hidden" id="installmentsNumber" name="installmentsNumber" value="<%= request.getParameter("installmentsNumber") %>">
                <input type="hidden" id="rateOfInterest" name="rateOfInterest" value="<%= request.getParameter("rateOfInterest") %>">
                <input type="hidden" id="fixedFee" name="fixedFee" value="<%= request.getParameter("fixedFee") %>">
                <input type="hidden" id="installmentsType" name="installmentsType" value="<%= request.getParameter("installmentsType") %>">

                <div class="form-group pull-left">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/">< Powróć do formularza</a>
                </div>
                <div class="form-group pull-right">
                    <input class="btn btn-danger" type="submit" value="Generuj PDF"/>
                </div>
                <table class="table table-striped">
                    <thead>
                        <tr class="info">
                            <td>Nr raty</td>
                            <td>Kwota Kapitału</td>
                            <td>Kwota odsetek</td>
                            <td>Opłaty stałe</td>
                            <td><strong>Całkowita kwota raty</strong></td>
                        </tr>
                    </thead>
                    <c:forEach var="paymentsScheduleItem" items="${paymentsScheduleList}">
                        <tr>
                            <td>${paymentsScheduleItem.installmentNumber}</td>
                            <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${paymentsScheduleItem.capitalAmount}"/></td>
                            <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${paymentsScheduleItem.interestAmount}"/></td>
                            <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${paymentsScheduleItem.fixedFee}"/></td>
                            <td><strong><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${paymentsScheduleItem.totalPaymentsAmount}"/></strong></td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>
    </body>
</html>