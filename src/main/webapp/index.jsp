<%@ page import="com.dawidrichert.utils.JspHelpers" %>
<%@ page import="com.dawidrichert.models.CalculationData" %>
<%@ page import="com.dawidrichert.models.enums.ContractType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="bodyContent">
    <form action="calculate" method="post" role="form">
        <c:if test="${not empty error}">
            <div class="alert alert-danger">
                <p>Wprowadzone dane są niekompletne lub niepoprawne.</p>
                <p>Pamiętaj o wypełnieniu wszystkich pól.</p>
            </div>
        </c:if>
        <input type="hidden" id="ContractType.PRACA" value="<%=ContractType.PRACA.toString()%>"/>
        <input type="hidden" id="ContractType.DZIELO" value="<%=ContractType.DZIELO.toString()%>"/>
        <input type="hidden" id="ContractType.ZLECENIE" value="<%=ContractType.ZLECENIE.toString()%>"/>
        <div class="col-md-6">
            <div class="form-group">
                <label for="<%=CalculationData.contractTypeKey%>">Rodzaj umowy</label>
                <div>
                    <div class="radio radio-inline">
                        <label><input type="radio" name="<%=CalculationData.contractTypeKey%>" value="0" checked>Umowa o pracę</label>
                    </div>
                    <div class="radio radio-inline">
                        <label><input type="radio" name="<%=CalculationData.contractTypeKey%>" value="1">Umowa o dzieło</label>
                    </div>
                    <div class="radio radio-inline">
                        <label><input type="radio" name="<%=CalculationData.contractTypeKey%>" value="2">Umowa zlecenie</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-3 form-group">
                    <label for="<%=CalculationData.yearKey%>">Rok</label>
                    <input value="<%=JspHelpers.emptyIfNull(request.getParameter(CalculationData.yearKey))%>"
                           class="form-control" type="number" id="<%=CalculationData.yearKey%>"
                           name="<%=CalculationData.yearKey%>" min="1900" max="2100" required/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 form-group">
                    <label for="<%=CalculationData.salaryKey%>">Kwota wynagrodzenia</label>
                    <div class="input-group">
                        <input value="<%=JspHelpers.emptyIfNull(request.getParameter(CalculationData.salaryKey))%>"
                               class="form-control" type="number" step="0.01" id="<%=CalculationData.salaryKey%>"
                               name="<%=CalculationData.salaryKey%>" min="0" max="999999999" aria-describedby="currency" required/>
                        <span class="input-group-addon" id="currency">zł</span>
                    </div>
                    <div class="radio radio-inline">
                        <label><input type="radio" name="<%=CalculationData.payTypeKey%>" value="0" checked>brutto</label>
                    </div>
                    <div class="radio radio-inline">
                        <label><input type="radio" name="<%=CalculationData.payTypeKey%>" value="1">netto</label>
                    </div>
                </div>
            </div>
            </br>
            </br>
            <div class="row col-md-6">
                <input class="btn btn-primary col-md-12" type="submit" value="Oblicz"/>
            </div>
        </div>
        <div class="col-md-6">
            <div id="dues" class="hidden">
                <div class="form-group">
                    <label for="<%=CalculationData.disabilityContributionKey%>">Składka rentowa</label>
                    <div>
                        <div class="radio radio-inline">
                            <label><input type="radio" name="<%=CalculationData.disabilityContributionKey%>" value="true" checked>tak</label>
                        </div>
                        <div class="radio radio-inline">
                            <label><input type="radio" name="<%=CalculationData.disabilityContributionKey%>" value="false">nie</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="<%=CalculationData.pensionContributionKey%>">Składka emerytalna</label>
                    <div>
                        <div class="radio radio-inline">
                            <label><input type="radio" name="<%=CalculationData.pensionContributionKey%>" value="true" checked>tak</label>
                        </div>
                        <div class="radio radio-inline">
                            <label><input type="radio" name="<%=CalculationData.pensionContributionKey%>" value="false">nie</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="<%=CalculationData.sicknessContributionKey%>">Składka chorobowa</label>
                    <div>
                        <div class="radio radio-inline">
                            <label><input type="radio" name="<%=CalculationData.sicknessContributionKey%>" value="true" checked>tak</label>
                        </div>
                        <div class="radio radio-inline">
                            <label><input type="radio" name="<%=CalculationData.sicknessContributionKey%>" value="false">nie</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="<%=CalculationData.healthCareContributionKey%>">Składka zdrowotna</label>
                    <div>
                        <div class="radio radio-inline">
                            <label><input type="radio" name="<%=CalculationData.healthCareContributionKey%>" value="true" checked>tak</label>
                        </div>
                        <div class="radio radio-inline">
                            <label><input type="radio" name="<%=CalculationData.healthCareContributionKey%>" value="false">nie</label>
                        </div>
                    </div>
                </div>
            </div>
            <div id="costs" class="hidden">
                <div class="form-group">
                    <label for="<%=CalculationData.deductibleCostsKey%>">Koszty uzyskania przychodu</label>
                    <div>
                        <div class="radio radio-inline">
                            <label><input type="radio" name="<%=CalculationData.deductibleCostsKey%>" value="0" checked>20%</label>
                        </div>
                        <div class="radio radio-inline">
                            <label><input type="radio" name="<%=CalculationData.deductibleCostsKey%>" value="1">50%</label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</c:set>
<t:layout pageTitle="Kalkulator płac">
    ${bodyContent}
</t:layout>