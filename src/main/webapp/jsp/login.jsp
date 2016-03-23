<%@ page import="com.dawidrichert.viewModels.LoginViewModel" %>
<%@ page import="com.dawidrichert.utils.JspHelpers" %>
<%@ page import="com.dawidrichert.utils.Resources" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="bodyContent">
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
        <div class="form-group text-right">
            <a class="btn btn-danger" href="<%=Resources.registerUrl%>">Register</a>
            <input class="btn btn-primary" type="submit" value="Login"/>
        </div>
    </form>
    <div class="panel-group">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" href="#collapseSampleAccountsPanel">Sample accounts</a>
                </h4>
            </div>
            <div id="collapseSampleAccountsPanel" class="panel-collapse collapse in">
                <table class="table">
                    <tr>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Role</th>
                    </tr>
                    <tr>
                        <td>john</td>
                        <td>potato</td>
                        <td>Basic</td>
                    </tr>
                    <tr>
                        <td>olivia</td>
                        <td>potato</td>
                        <td>Premium</td>
                    </tr>
                    <tr>
                        <td>chris</td>
                        <td>potato</td>
                        <td>Admin</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</c:set>
<t:layout pageTitle="Login">
    ${bodyContent}
</t:layout>