<%@page import="springmvc.HelloDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
HelloDTO model = (HelloDTO)request.getAttribute("model");
%>
<h3>jsp 변수 <%=model.getMessage() %></h3>
<h3>el변수 ${model }</h3>
</body>
</html>