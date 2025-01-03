package nonspring;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<HelloDTO> list = new ArrayList<>();
		list.add(new HelloDTO("모델1"));
		list.add(new HelloDTO("모델2"));
		list.add(new HelloDTO("모델3"));
		request.setAttribute("list",list);
		return "list.jsp";
	}

}
