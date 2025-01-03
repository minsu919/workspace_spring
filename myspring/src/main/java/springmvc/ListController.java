package springmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<HelloDTO> list = new ArrayList();
		list.add(new HelloDTO("모델1"));
		list.add(new HelloDTO("모델2"));
		list.add(new HelloDTO("모델3"));
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("list");
		return mv;
	}

}
