<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="bodyContent">
    <h4 class="text-danger">Sorry, you don't have access to see this page.</h4>
</c:set>
<t:layout pageTitle="No access">
    ${bodyContent}
</t:layout>