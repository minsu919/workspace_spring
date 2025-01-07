<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 리스트</h1>
<table border=2>
<tr>
<td>아이디</td>
<td>이름</td>
<td>전화번호</td>
<td>이메일</td>
<td>가입일</td>
</tr>
<c:forEach items="${list }" varStatus="vs">
<tr>
<td>${vs.current.id}</td>
<td>${vs.current.name}</td>
<td>${vs.current.phone}</td>
<td>${vs.current.email}</td>
<td>${vs.current.regdate}</td>
</tr>
</c:forEach>

</table>
</body>
</html>