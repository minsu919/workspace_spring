<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1>아이디입력폼</h1>
<form>
	아이디<input type=text name="id" id="id"><br>
	비밀번호<input type="password" name="pw" id="pw"><br>
	<input type=button id="listbtn" value="회원아이디리스트">
</form>

<div id="pwresult"></div>
<div id="list"></div>

<script src="resources/js/jquery-3.7.1.min.js"></script>
<script>
	$("#listbtn").on('click', function(){
		$.ajax( {
			url : "ajaxadminlist",
			data : {'id':$("input[name=id]").val(), 'pw': $("input[name=pw]").val() },
			type : 'get',
			dataType : 'json',
			
			success : function(response){ // @ResponseBody ArrayList=배열타입
				$("#list").css("background-color","silver");
				$("#list").html("");
				for (let i=0; i<response.length; i++){
					$("#list").append("<h3><a href=''>" + response[i].id + "</a></h4>"); // ?????????
				}
			},
			error : function(request, status, error){
				alert("코드" + request.status + "\n 메시지=" + request.responseText + "\n오류=" + error);
			}
	 	 } ); // ajax
	}); //on
	
	// 동적 이벤트 처리 생성 추가 태그의 이벤트 처리
	
	$("#list").on('click', 'a', function(ev){
		ev.preventDefault();
		$.ajax( {
			url : "getpw/" + $(this).text(),
			type : 'get',
			dataType : 'json',
			
			success : function(response){
				if(response.pw) {  // 암호가 있을 때
					$("#pwresult").css("background-color","silver");
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
	}); //on
</script>
</body>
</html>