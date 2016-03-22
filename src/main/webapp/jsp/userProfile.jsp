<%@ page import="com.dawidrichert.utils.JspHelpers" %>
<%@ page import="com.dawidrichert.models.enums.Permission" %>
<%@ page import="com.dawidrichert.utils.Resources" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Register</title>
    <link rel="icon" type="image/png" href="../img/favicon.png"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/app.css">
    <script src="../js/jquery-1.12.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="center-element col-sm-4">
        <h2>Hi <%=request.getAttribute("username")%>!</h2>
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
    </div>
</div>
</body>
</html>