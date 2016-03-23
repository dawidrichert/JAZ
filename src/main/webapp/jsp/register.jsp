<%@ page import="com.dawidrichert.utils.JspHelpers" %>
<%@ page import="com.dawidrichert.viewModels.RegisterViewModel" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="bodyContent">
    <form action="register" method="post" role="form">
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger">
                <p>${errorMessage}</p>
            </div>
        </c:if>
        <div class="form-group">
            <label for="<%=RegisterViewModel.userNameKey%>">Username</label>
            <input value="<%=JspHelpers.emptyIfNull(request.getParameter(RegisterViewModel.userNameKey))%>"
                   class="form-control" type="text" id="<%=RegisterViewModel.userNameKey%>"
                   name="<%=RegisterViewModel.userNameKey%>" required/>
        </div>
        <div class="form-group">
            <label for="<%=RegisterViewModel.passwordKey%>">Password</label>
            <input class="form-control" type="password" id="<%=RegisterViewModel.passwordKey%>"
                   name="<%=RegisterViewModel.passwordKey%>" required/>
        </div>
        <div class="form-group">
            <label for="<%=RegisterViewModel.confirmPasswordKey%>">Confirm password</label>
            <input class="form-control" type="password" id="<%=RegisterViewModel.confirmPasswordKey%>"
                   name="<%=RegisterViewModel.confirmPasswordKey%>" required/>
        </div>
        <div class="form-group">
            <label for="<%=RegisterViewModel.emailKey%>">E-mail</label>
            <input value="<%=JspHelpers.emptyIfNull(request.getParameter(RegisterViewModel.emailKey))%>"
                   class="form-control" type="email" id="<%=RegisterViewModel.emailKey%>"
                   name="<%=RegisterViewModel.emailKey%>" required/>
        </div>
        <div class="form-group text-right">
            <a class="btn btn-default" href="${pageContext.request.contextPath}/">Cancel</a>
            <input class="btn btn-primary" type="submit" value="Register"/>
        </div>
    </form>
</c:set>
<t:layout pageTitle="Register">
    ${bodyContent}
</t:layout>