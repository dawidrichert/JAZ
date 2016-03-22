<%@ page import="com.dawidrichert.utils.Resources" %>
<%
    session.invalidate();
    response.sendRedirect(Resources.loginUrl);
%>