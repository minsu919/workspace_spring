<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Model 인터페이스 저장 객체 : ${model2}</h3>
<h3>ModelMap 저장 객체 : ${model3}</h3>
<h3>ModelMap 저장 객체 : ${model4}</h3>
<h3>ModelAndView 저장 객체 : ${model5}</h3>
<h3>${model.id } 회원님 환영합니다.</h3>
${model.pw }
<img src="resources/images/jquery.png">
<script src="resources/js/jquery-3.7.1.min.js"></script>
<script>
//jquery source
$(document).ready(function(){
	alert("보입니");
})
</script>
</body>
</html>