<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="bodyContent">
    <h4 class="text-info">It's a premium page.</h4>
    <a class="btn btn-default" href="${pageContext.request.contextPath}/">< Back</a>
</c:set>
<t:layout pageTitle="Premium">
    ${bodyContent}
</t:layout>