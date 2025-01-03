package annotation.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public ModelAndView handle(/*HttpServletRequest request, HttpServletResponse response*/) throws Exception {
		HelloDTO dto = new HelloDTO();
		dto.setMessage("컨트롤러가 jsp로 전달하는 모델입니다");
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", dto);
		mv.setViewName("hello");
		return mv;
		}
	
	
	
//	@Override
//	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		// c - model + 전달 + jsp
//		HelloDTO dto = new HelloDTO();
//		dto.setMessage("컨트롤러가 jsp로 전달하는 모델입니다");
//		request.setAttribute("model", dto);
//		return "hello.jsp";
//	}
	
	
}
