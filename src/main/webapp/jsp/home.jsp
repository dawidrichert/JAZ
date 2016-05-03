<%@ page import="com.dawidrichert.utils.Resources" %>
<%@ page import="com.dawidrichert.utils.Config" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="bodyContent">
    <c:choose>
        <c:when test="${empty weatherData}">
            <div class="col-md-12 alert alert-danger">
                <p>Niestety, nie udało się pobrać danych pogodowych.</p>
                <p>Spróbuj ponownie za chwilę.</p>
                <br/>
                <a class="btn btn-danger" href="${pageContext.request.contextPath}/">Odśwież stronę</a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="form-group pull-left">
                <c:forEach var="item" items="<%=Config.listOfAllowedCities%>">
                    <a class="btn btn-primary" href="<%=Resources.homeUrl%>?city=${item}">${item}</a>
                </c:forEach>
            </div>
            <table class="table table-striped">
                <thead>
                <tr class="info">
                    <td class="text-left"><strong>Data</strong></td>
                    <td class="center-column"><strong>Poziom zachmurzenia</strong></td>
                    <td class="text-right"><strong>Temperatura</strong></td>
                    <td class="text-right"><strong>Ciśnienie</strong></td>
                    <td class="text-right"><strong>Prędkość wiatru</strong></td>
                </tr>
                </thead>
                <c:forEach var="item" items="${weatherData.list}">
                    <tr>
                        <td class="text-left">${item.dtTxt}</td>
                        <td class="center-column">${item.weather.get(0).description}</td>
                        <td class="text-right"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.main.temp}"/> °С</td>
                        <td class="text-right"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.main.pressure}"/> hPa</td>
                        <td class="text-right"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.wind.speed}"/> m/s</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</c:set>
<t:layout pageTitle="Pogoda ${weatherData.city.name}">
    ${bodyContent}
</t:layout>