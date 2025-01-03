package nonspring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// controller 들은 반드시 상속, 오버라이딩 
public interface Controller {
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
