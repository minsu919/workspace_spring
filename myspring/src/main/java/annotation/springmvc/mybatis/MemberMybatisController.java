package annotation.springmvc.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberMybatisController {
	
	@Autowired
	MemberService memberservice;
	
	@RequestMapping("/membermybatislist")
	public ModelAndView memberlist() {
		ModelAndView mv = new ModelAndView();
		
		List<MemberDTO> list = memberservice.memberList();
		int membercount = memberservice.memberCount();
		mv.addObject("membercount", membercount);
		mv.addObject("memberlist", list);
		
		mv.setViewName("mybatis/memberlist");		
		return mv;
	}
	
	@RequestMapping("/membersearchlist")
	public ModelAndView membersearchlist(String item, String searchword) {
		ModelAndView mv = new ModelAndView();
		
//		MemberDTO dto = new MemberDTO();
//		if (item.equals("name")) {
//			dto.setName(searchword);
//		} else if ~~
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("colname", item);
		map.put("colvalue", "%" + searchword + "%");
		
		List<MemberDTO> list = memberservice.memberSearchList(map);
		mv.addObject("memberlist", list);
		mv.setViewName("mybatis/memberlist");
		return mv;
	}
}
