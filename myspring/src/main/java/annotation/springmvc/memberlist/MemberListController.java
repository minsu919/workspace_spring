package annotation.springmvc.memberlist;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberListController {
	
	@Autowired
	ListService listservice;
	
	@RequestMapping("/memberlist")
	ModelAndView getList(@RequestParam(value="pagenum", defaultValue="0") int pagenum) {
		
		ArrayList<MemberDTO> list = listservice.getMemberList(pagenum);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName("memberlist");
		return mv;
	}
	
}
