<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="bodyContent">
    <table class="table table-striped">
        <thead>
        <tr class="info">
            <td>Username</td>
            <td>Email</td>
            <td>Premium</td>
        </tr>
        </thead>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.userName}</td>
                <td>${user.email}</td>
                <td>
                    <form action="premiumManager" method="post" role="form">
                        <input type="hidden" name="username" value="${user.userName}"/>
                        <c:choose>
                            <c:when test="${user.hasPremiumManagerAccess}">
                                <input class="btn btn-success" type="submit" value="On" disabled/>
                            </c:when>
                            <c:when test="${user.hasPremiumAccess}">
                                <input class="btn btn-success" type="submit" value="On"/>
                            </c:when>
                            <c:otherwise>
                                <input class="btn btn-danger" type="submit" value="Off"/>
                            </c:otherwise>
                        </c:choose>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a class="btn btn-default" href="${pageContext.request.contextPath}/">< Back</a>
</c:set>
<t:layout pageTitle="Premium manager">
    ${bodyContent}
</t:layout>