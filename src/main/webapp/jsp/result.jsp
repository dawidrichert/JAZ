<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="bodyContent">
    <div class="form-group pull-left">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/">< Powróć do formularza</a>
    </div>
    <c:choose>
        <c:when test="${contractType=='PRACA'}">
            <table class="table table-striped">
                <thead>
                <tr class="info">
                    <th rowspan="2" class="center-column">Miesiąc</th>
                    <th rowspan="2" class="center-column">Brutto</th>
                    <td colspan="4" class="center-column">Ubezpieczenie</td>
                    <td rowspan="2" class="center-column">Podstawa opodatkowania</td>
                    <td rowspan="2" class="center-column">Zaliczka na PIT</td>
                    <th rowspan="2" class="center-column">Netto</th>
                </tr>
                <tr class="info">
                    <td class="center-column">emerytalne</td>
                    <td class="center-column">rentowe</td>
                    <td class="center-column">chorobowe</td>
                    <td class="center-column">zdrowotne</td>
                </tr>
                </thead>
                <c:forEach var="pracaItem" items="${list}">
                    <tr>
                        <td class="center-column"><strong>${pracaItem.miesiac}</strong></td>
                        <td class="center-column"><strong><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${pracaItem.brutto}"/></strong></td>
                        <td class="center-column"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${pracaItem.emerytalne}"/></td>
                        <td class="center-column"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${pracaItem.rentowe}"/></td>
                        <td class="center-column"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${pracaItem.chorobowe}"/></td>
                        <td class="center-column"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${pracaItem.zdrowotne}"/></td>
                        <td class="center-column"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${pracaItem.podstawaOpodatkowania}"/></td>
                        <td class="center-column"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${pracaItem.zaliczkaPIT}"/></td>
                        <td class="center-column"><strong><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${pracaItem.netto}"/></strong></td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:when test="${contractType=='ZLECENIE'}">
            <table class="table table-striped">
                <thead>
                <tr class="info">
                    <th rowspan="2" class="center-column">Brutto</th>
                    <td colspan="4" class="center-column">Ubezpieczenie</td>
                    <td rowspan="2" class="center-column">Koszt uzyskania przychodu</td>
                    <td rowspan="2" class="center-column">Podstawa opodatkowania</td>
                    <td rowspan="2" class="center-column">Zaliczka na PIT</td>
                    <th rowspan="2" class="center-column">Netto</th>
                </tr>
                <tr class="info">
                    <td class="center-column">emerytalne</td>
                    <td class="center-column">rentowe</td>
                    <td class="center-column">chorobowe</td>
                    <td class="center-column">zdrowotne</td>
                </tr>
                </thead>
                <c:forEach var="zlecenieItem" items="${list}">
                    <tr>
                        <td class="center-column"><strong><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${zlecenieItem.brutto}"/></strong></td>
                        <td class="center-column"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${zlecenieItem.emerytalne}"/></td>
                        <td class="center-column"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${zlecenieItem.rentowe}"/></td>
                        <td class="center-column"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${zlecenieItem.chorobowe}"/></td>
                        <td class="center-column"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${zlecenieItem.zdrowotne}"/></td>
                        <td class="center-column"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${zlecenieItem.kosztUzyskaniaPrzychodu}"/></td>
                        <td class="center-column"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${zlecenieItem.podstawaOpodatkowania}"/></td>
                        <td class="center-column"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${zlecenieItem.zaliczkaPIT}"/></td>
                        <td class="center-column"><strong><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${zlecenieItem.netto}"/></strong></td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:when test="${contractType=='DZIELO'}">
            <table class="table table-striped">
                <thead>
                <tr class="info">
                    <th class="center-column">Brutto</th>
                    <td class="center-column">Koszt uzyskania przychodu</td>
                    <td class="center-column">Podstawa opodatkowania</td>
                    <td class="center-column">Zaliczka na PIT</td>
                    <th class="center-column">Netto</th>
                </tr>
                </thead>
                <c:forEach var="dzieloItem" items="${list}">
                    <tr>
                        <td class="center-column"><strong><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${dzieloItem.brutto}"/></strong></td>
                        <td class="center-column"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${dzieloItem.kosztUzyskaniaPrzychodu}"/></td>
                        <td class="center-column"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${dzieloItem.podstawaOpodatkowania}"/></td>
                        <td class="center-column"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${dzieloItem.zaliczkaPIT}"/></td>
                        <td class="center-column"><strong><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${dzieloItem.netto}"/></strong></td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            pizzas.
            <br />
        </c:otherwise>
    </c:choose>
</c:set>
<t:layout pageTitle="Kalkulator płac">
    ${bodyContent}
</t:layout>