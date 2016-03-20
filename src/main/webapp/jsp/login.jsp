<%@ page import="com.dawidrichert.viewModels.LoginViewModel" %>
<%@ page import="com.dawidrichert.utils.JspHelpers" %>
<%@ page import="com.dawidrichert.utils.Resources" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Login</title>
    <link rel="icon" type="image/png" href="../img/favicon.png"/>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/app.css">
    <script src="../js/jquery-1.12.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="center-element col-sm-4">
        <h2>Zadanie 2</h2>
        </br>
        <form action="login" method="post" role="form">
            <c:if test="${not empty successMessage}">
                <div class="alert alert-success">
                    <p>${successMessage}</p>
                </div>
            </c:if>
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger">
                    <p>${errorMessage}</p>
                </div>
            </c:if>
            <div class="form-group">
                <label for="<%=LoginViewModel.userNameKey%>">Username</label>
                <input value="<%=JspHelpers.emptyIfNull(request.getParameter(LoginViewModel.userNameKey))%>"
                       class="form-control" type="text" id="<%=LoginViewModel.userNameKey%>"
                       name="<%=LoginViewModel.userNameKey%>" required/>
            </div>
            <div class="form-group">
                <label for="<%=LoginViewModel.passwordKey%>">Password</label>
                <input value="<%=JspHelpers.emptyIfNull(request.getParameter(LoginViewModel.passwordKey))%>"
                       class="form-control" type="password" id="<%=LoginViewModel.passwordKey%>"
                       name="<%=LoginViewModel.passwordKey%>" required/>
            </div>
            <div class="form-group pull-right">
                <a class="btn btn-danger" href="<%=Resources.registerUrl%>">Register</a>
                <input class="btn btn-primary" type="submit" value="Login"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>