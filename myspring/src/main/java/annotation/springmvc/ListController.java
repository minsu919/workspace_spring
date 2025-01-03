package annotation.springmvc;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController{

	@RequestMapping("/list")
	public ModelAndView handle() {
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
