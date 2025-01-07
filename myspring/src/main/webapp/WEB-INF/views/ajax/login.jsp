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
	$("#ajaxbtn").on('click', function(){
		$.ajax( {
			url : "ajaxlogin",
			data : {'id':$("input[name=id]").val(), 'pw':$("input[name=pw]").val() },
			type : 'post',
			dataType : 'json',
			success : function(response){
				$("#result").html(response.loginresult);
				$("#result").css("border","2px solid blue");
				if (response.loginresult == "로그인 성공"){
					$("#result").css("color", "green");
					} 
				else {
					$("#result").css("color","red");}
				},
			error : function(request, status, error){
				alert("코드" + request.status + "\n 메시지=" + request.responseText + "\n오류=" + error);
				}
		  } ); // ajax
	}); // on
	
	$("#ajaxbtn2").on('click', function(){
		$.ajax( {
			url : "ajaxmyinform",
			data : {'id':$("input[name=id]").val(), 'pw':$("input[name=pw]").val() },
			type : 'get',
			dataType : 'json',
			success : function(response){
				$("#result").html("<h3>아이디=" + response.id + "</h3>");
				$("#result").append("<h3>이름=" + response.name + "</h3>");
				$("#result").append("<h3>이메일=" + response.email + "</h3>");
				$("#result").append("<h3>폰번호=" + response.phone + "</h3>");
				$("#result").append("<h3>가입일=" + response.regdate + "</h3>");
				
				$("#result").css("border","2px solid blue");
				},
			error : function(request, status, error){
				alert("코드" + request.status + "\n 메시지=" + request.responseText + "\n오류=" + error);
				}
	 	 } ); // ajax
	}); // on
	
	$("#ajaxbtn3").on('click', function(){
		$.ajax( {
			url : "ajaxlist",
			data : {'id':$("input[name=id]").val(), 'pw':$("input[name=pw]").val() },
			type : 'get',
			dataType : 'json',
			success : function(response){ // @ResponseBody ArrayList=배열타입
				$("#result").html("");
				for (let i=0; i<response.length; i++){
					$("#result").append("<h3>아이디=" + response[i].id + "</h3>");
					$("#result").append("<h3>이름=" + response[i].name + "</h3>");
					$("#result").append("<h3>이메일=" + response[i].email + "</h3>");
					$("#result").append("<h3>폰번호=" + response[i].phone + "</h3>");
					$("#result").append("<h3>가입일=" + response[i].regdate + "</h3>");
				}
				$("#result").css("border","2px solid blue");
				},
			error : function(request, status, error){
				alert("코드" + request.status + "\n 메시지=" + request.responseText + "\n오류=" + error);
				}
	 	 } ); // ajax
	}); // on
	
	$("#uploadbtn").on('click', function(){ // 파일 업로드
		let data = new FormData($("#uploadForm")[0]); // form 태그 jquery 객체명
		$.ajax( {
			url : "ajaxupload",
			data : new FormData($("#uploadForm")[0]),
			type : 'post',
			encType : "multipart/form-data",
			processData : false,
			contentType : false,
			
			dataType : 'json',
			success : function(response){ // @ResponseBody ArrayList=배열타입
				$("#uploadresult").html("");
				$("#uploadresult").append("<h3>업로드결과" + response.uploadresult+ "</h3>");
				$("#uploadresult").css("border","2px solid blue");
				},
			error : function(request, status, error){
				alert("코드" + request.status + "\n 메시지=" + request.responseText + "\n오류=" + error);
				}
	 	 } ); // ajax
	}); // on

	$("a").on('click', function(ev){ // 파일 업로드
		alert($(this).text());
		ev.preventDefault();
		$.ajax( {
			url : "ajaxrole/" + $(this).text(),
			type : 'get',
			
			dataType : 'json',
			success : function(response){ // @ResponseBody ArrayList=배열타입
				$("#result").html("");
				$("#result").append("<h3>롤 = " + response.role+ "</h3>");
				$("#result").css("border","2px solid blue");
				},
			error : function(request, status, error){
				alert("코드" + request.status + "\n 메시지=" + request.responseText + "\n오류=" + error);
				}
	 	 } ); // ajax
	}); // on
	
}); // end
</script>
</head>
<body>
<h1>로그인폼</h1>
<form action="nonajaxlogin" method="post">
	아이디<input type="text" name="id"><br>
	비밀번호<input type="password" name="pw"><br>
	<input type="submit" value="로그인">
	<input type=button value="ajax로그인" id="ajaxbtn">
	<input type=button value="ajax내정보조회" id="ajaxbtn2">
	<input type=button value="ajax회원리스트" id="ajaxbtn3">
</form>

<!--  
ajax - admin/user/blacklist
a 태그의 기본동작 말고 다른 동작
 -->
<h3><a href="ajaxrole/">spring</a>나의 역할 구분</h3>
<h3><a href="ajaxrole/">admin</a>나의 역할 구분 </h3>
<h3><a href="ajaxrole/">test</a>나의 역할 구분 </h3>

<div id="result"></div>

<hr>
<h1>파일업로드폼</h1>
<form id="uploadForm">
	파일설명:<input type=text name="detail"><br>
	파일선택:<input type=file name="uploadfile"><br>
	<input type=button value="ajax파일업로드" id="uploadbtn">
</form>
<div id="uploadresult"></div>
</body>
</html>