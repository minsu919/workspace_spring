<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	
	$("#listbtn").on('click', function(){
		$.ajax( {
			url : "ajaxlisttest",
			data : {'id':$("input[name=id]").val(), 'pw': $("input[name=pw]").val() },
			type : 'get',
			dataType : 'json',
			success : function(response){ // @ResponseBody ArrayList=배열타입
				$("#list").html("");
				for (let i=0; i<response.length; i++){
					$("#list").append("<h3><a href=\"getpw/" + response[i].id + "\">" + response[i].id + "</a>암호확인</h3>"); // ?????????
				}
				$("#list").css("border","2px solid blue");
				},
			error : function(request, status, error){
				alert("코드" + request.status + "\n 메시지=" + request.responseText + "\n오류=" + error);
				}
	 	 } ); // ajax
	});
	
	$("a").on('click', function(ev){
		ev.preventDefault();
		$.ajax( {
			url : "getpw/" + $(this).text(),
			type : 'get',
	
			dataType : 'json',
			success : function(response){
				if(response.pw) {  // 암호가 있을 때
	                $("#pwresult").html("<h3> 암호 = " + response.pw + "</h3>");
	            } else {  // 암호가 없을 경우 (해당 아이디가 없을 때)
	                $("#pwresult").html("<h3>해당 아이디가 없습니다.</h3>");
	            }
				$("#pwresult").css("border","2px solid blue");
				},
			error : function(request, status, error){
				alert("코드" + request.status + "\n 메시지=" + request.responseText + "\n오류=" + error);
				}
		} ); // ajax
	});
	
});
</script>
</head>
<body>
<h1>리스트과제</h1>
<form action=>
	아이디<input type=text name="id" id="id"><br>
	비밀번호<input type="password" name="pw" id="pw"><br>
	<input type=button id="listbtn" value="회원아이디리스트">
</form>

<div id="list"></div>
<div id="pwresult"></div>
</body>
</html>