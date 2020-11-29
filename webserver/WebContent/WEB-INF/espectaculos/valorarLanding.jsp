<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <jsp:include page="/WEB-INF/template/head.jsp"/>

        <title>CoronaTickets.uy</title>
</head>
<body>
	<h1> <%= session.getAttribute("errorValorar") %></h1>
</body>
</html>