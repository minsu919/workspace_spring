package nonspring;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/") // http://127.0.0.1:8091/nonspring/hello
public class DispatcherServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // nonspring/hello
		String uri_array[] = uri.split("/");
		String result = uri_array[uri_array.length - 1];
		//System.out.println(result);
		
		// hello - HelloController 호출
		HandlerMapping mappings = new HandlerMapping();
		Controller controller = mappings.getController(result);
		String jspfile = controller.handleRequest(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher(jspfile);
		rd.forward(request, response);
	}

}
