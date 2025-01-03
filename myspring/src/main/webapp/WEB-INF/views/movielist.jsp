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
<%
HashMap<String, Integer> moviemap = (HashMap<String, Integer>) request.getAttribute("moviemap");
%>

<h1>영화 신청 페이지</h1>
<form action="moviereserve" method=post>
	아이디<input type="text" name="id"><br>
	암호<input type="password" name="pw"><br>
	나이<input type="text" name="age"><br>
	<h3>영화 목록</h3>
    <%
    if (moviemap != null) {
        for (String movieTitle : moviemap.keySet()) {
            // 영화 제목을 key로 사용하고, Integer 값은 사용하지 않음
    %>
        <label>
            <input type="checkbox" name="movies" value="<%= movieTitle %>"> <%= movieTitle %>
        </label><br>
    <% 
        }
    }
    %>
	<input type="submit" value="영화 신청">
</form>
</body>
</html>