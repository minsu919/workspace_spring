package annotation.springmvc.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component("chatwebsocket")
public class ChatWebSocketHandler implements WebSocketHandler { // 모든 메소드 구현 (사용하지 않아도 구현해놓아야한다)
	
	// 웹소켓 접속 사용자들 저장관리 리스트
	List<WebSocketSession> list = new ArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(session.getRemoteAddress() + " 에서 접속했습니다"); // list 사용자 추가
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(session.getRemoteAddress() + " 에서 접속 해제했습니다"); // list 사용자 삭제
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// 엡소켓 클라이언트로부터 메시지 받을 때 실행-websocket.send 호출
		System.out.println(session.getRemoteAddress() + " 와 접속중입니다"); // list 내 모든 사용자에게 대화 전송
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

}
