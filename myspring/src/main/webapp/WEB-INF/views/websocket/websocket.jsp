<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
별명:<input type=text id="nickname">
<input type=button id="enterbtn" value="입장버튼">
<input type=button id="exitbtn" value="퇴장버튼">

<h1>채팅창</h1>
<div id="chatmessagearea" style="background-color:yellow; border:2px solid black">대화내용 출력<br></div>
<input type=text id="message">
<input type=button id="sendbtn" value="대화전송">

<script src="resources/js/jquery-3.7.1.min.js"></script>
<script>
let websocket;
$(function(){
	$("#enterbtn").on('click', function(){
		// http://localhost:8091/ezwel/chat
		websocket = new WebSocket("ws://localhost:8091/ezwel/chatws");
		// 서버 통신 시작. websocket.onopen 연결 함수 같이 호출실행
		websocket.onopen = onOpen;
		websocket.onclose = onClose;
		websocket.onmessage = onMessage;
	});
	
	$("#exitbtn").on('click', function(){
		websocket.close();
	});
	
	$("#sendbtn").on('click', function(){
		let nickname = $("#nickname").val();
		let msg = $("#message").val();
		websocket.send(nickname + " : " + msg);
	});
});

function onOpen(){
	console.log("웹소켓 연결성공");
	let nickname = $("#nickname").val();
	websocket.send(nickname + " 님이 대화방에 입장하셨습니다.");
	
}
function onClose(){
	console.log("웹소켓 연결해제성공");
	$("#chatmessagearea").html("");
}
function onMessage(ev){ // 웹소켓 서버로부터 메시지 받은 이벤트 객체
	console.log("서버로부터 대화 받기 성공");
	$("#chatmessagearea").append(ev.data + "<br>");
}
</script>
</body>
</html>