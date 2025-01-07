package annotation.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogController {
	
	private static final Logger logger = LoggerFactory.getLogger(LogController.class);
	
	@RequestMapping("/logtest")
	public void logtest(HttpServletRequest request) { // void = view 이름은 url 동일 (logtest.jsp)
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr();
		logger.trace("welcome 내 서버! 요청 클라이언트 ip = {} 에서 {} 를 요청했습니다.", new String[] {ip, uri});
		logger.info("welcome 내 서버! 요청 클라이언트 ip = {} 에서 {} 를 요청했습니다.", new String[] {ip, uri});
		logger.debug("welcome 내 서버! 요청 클라이언트 ip = {} 에서 {} 를 요청했습니다.", new String[] {ip, uri});
		logger.warn("welcome 내 서버! 요청 클라이언트 ip = {} 에서 {} 를 요청했습니다.", new String[] {ip, uri});
		logger.error("welcome 내 서버! 요청 클라이언트 ip = {} 에서 {} 를 요청했습니다.", new String[] {ip, uri});
	}
}
