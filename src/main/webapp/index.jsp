<%@ page import="com.dawidrichert.utils.JspHelpers" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Kalkulator rat kredytu</title>
        <link rel="icon" type="image/png" href="../img/favicon.png" />
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/app.css">
        <script src="../js/jquery-1.12.1.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="center-element col-sm-4">
                <h2>Zadanie 1</h2>
                </br>
                <form action="harmonogram" method="post" role="form">
                    <c:choose>
                        <c:when test="${not empty error}">
                            <div class="alert alert-danger">
                                <p>Wprowadzone dane są niekompletne lub niepoprawne.</p>
                                <p>Pamiętaj o wypełnieniu wszystkich pól.</p>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="alert alert-info">
                                <p>Wypełnij wszystkie pola.</p>
                            </div>
                        </c:otherwise>
                    </c:choose>
                    <div class="form-group">
                        <label for="requestedCreditAmount">Wnioskowana kwota kredytu</label>
                        <input value="<%=JspHelpers.emptyIfNull(request.getParameter("requestedCreditAmount"))%>" class="form-control" type="number" step="any" min="500" max="9999999999" id="requestedCreditAmount" name="requestedCreditAmount" required/>
                    </div>
                    <div class="form-group">
                        <label for="installmentsNumber">Ilość rat</label>
                        <input value="<%=JspHelpers.emptyIfNull(request.getParameter("installmentsNumber"))%>" class="form-control" type="number" min="1" max="1200" id="installmentsNumber" name="installmentsNumber" required/>
                    </div>
                    <div class="form-group">
                        <label for="rateOfInterest">Oprocentowanie</label>
                        <input value="<%=JspHelpers.emptyIfNull(request.getParameter("rateOfInterest"))%>" class="form-control" type="number" step="any" min="0" max="50" id="rateOfInterest" name="rateOfInterest" required/>
                    </div>
                    <div class="form-group">
                        <label for="fixedFee">Opłata stała</label>
                        <input value="<%=JspHelpers.emptyIfNull(request.getParameter("fixedFee"))%>" class="form-control" type="number" step="any" min="0" id="fixedFee" name="fixedFee" required/>
                    </div>
                    <div class="form-group">
                        <label for="installmentsType1">Rodzaj rat</label>
                        <div class="form-group">
                            <label class="radio-inline">
                              <input type="radio" name="installmentsType" id="installmentsType1" value="0" checked> malejąca
                            </label>
                            <label class="radio-inline">
                              <input type="radio" name="installmentsType" id="installmentsType2" value="1"> stała
                            </label>
                        </div>
                    </div>
                    <div class="form-group pull-right">
                        <input class="btn btn-primary" type="submit" value="Oblicz"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>