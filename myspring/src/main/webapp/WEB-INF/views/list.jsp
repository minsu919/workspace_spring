<%@page import="annotation.springmvc.HelloDTO"%>
<%@page import="java.util.ArrayList"%>
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
ArrayList<HelloDTO> list = (ArrayList<HelloDTO>)request.getAttribute("list");
for (HelloDTO dto : list){
%>
	<h3><%= dto %></h3>
<%
}
%>
</body>
</html>