<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="searchform" action="membersearchlist">
<select name="item">
	<option value="name">이름검색</option>
	<option value="phone">폰번호검색</option>
	<option value="email">이메일검색</option>
	<option value="id">아이디검색</option>
</select>
검색어:<input type="text" name="searchword">
<input type=submit value="검색요청">
<input type=submit value="모든회원리스트">
</form>
<script src="resources/js/jquery-3.7.1.min.js"></script>
<script>
$("#searchform").on('submit', function(){
	if($("input:submit").val() == "모든회원리스트"){
		$("#searchform").attr("action","membermybatislist");
	}
});
</script>
<!-- 
1>검색요청 클릭하면 membersearchlist url ㅐ핑 컨트롤러 메소드 호출
2>item=이름검색 -> MemberDTO dto = new MemberDTO(); dto.setName(searchword 변수)
3> Service method 호출 - 이미 구현 완
4> 3번 결과 모델 - mybatis/memberlist.jsp 검색 리스트 출력
-->

<h1>회원 리스트 출력</h1>
<c:forEach items="${memberlist }" var="dto" varStatus="vs">
	<h3>${dto.id } : ${dto.name } : ${dto.email } : ${dto.phone }</h3>
</c:forEach>
	<h1>총회원수 : ${membercount }</h1>
</body>
</html>