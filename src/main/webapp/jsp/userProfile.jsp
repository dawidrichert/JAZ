<%@ page import="com.dawidrichert.utils.JspHelpers" %>
<%@ page import="com.dawidrichert.models.enums.Permission" %>
<%@ page import="com.dawidrichert.utils.Resources" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="bodyContent">
    <h3>Hi <%=request.getAttribute("username")%>!</h3>
    <h5>What you want to do?</h5>
    </br>
    <form method="link" action="/jsp/logout.jsp">
    <c:if test='<%=JspHelpers.hasPermission((String)session.getAttribute("username"), Permission.PREMIUM)%>'>
        <a class="btn btn-success" href="<%=Resources.premiumUrl%>">Premium</a>
    </c:if>
    <c:if test='<%=JspHelpers.hasPermission((String)session.getAttribute("username"), Permission.PREMIUM_MANAGER)%>'>
        <a class="btn btn-danger" href="<%=Resources.premiumUrl%>">Manage Premium Accounts</a>
    </c:if>
    <input class="btn btn-primary" type="submit" value="Logout"/>
    </form>
</c:set>
<t:layout pageTitle="User profile">
    ${bodyContent}
</t:layout>