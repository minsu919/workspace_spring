<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>영화 예약 결과</h1>
<h3>${id } 회원님 ${age }살 입니다.</h3>
@시청가능 영화 목록@<ul>
<%
HashMap<String, Integer> moviemap = (HashMap<String, Integer>) request.getAttribute("moviemap");
int age = (Integer)request.getAttribute("age");
%>
<%
String[] movies = (String[])request.getAttribute("movies");
for (String movie : movies){
	if (moviemap.containsKey(movie) && (age >= moviemap.get(movie))){
%>
	<li><%=movie %>,<%=moviemap.get(movie) %>세</li>
<%
	}
}
%>
</ul>
</body>
</html>