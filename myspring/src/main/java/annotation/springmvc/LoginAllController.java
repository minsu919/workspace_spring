package annotation.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAllController {
	
	// 로그인폼 요청처리
	//@RequestMapping(value = "/login", method = RequestMethod.GET)
	@GetMapping("/login")
	public ModelAndView form() throws Exception {
		ModelAndView mv = new ModelAndView();
		// model 생성
		mv.addObject("title", "로그인폼");
		
		// view 생성
		mv.setViewName("loginform");
		return mv;
		
	}
	// 로그인 요청처리

	// test6
	@PostMapping("/login")
	// 컨트롤러 메소드 매개변수 타입이 객체이고 요청 파라미터 이름 동일한 객체 내부의 변수 이름 자동 주입(단 매개변수 선언 타입과 같은 값 입력. 형변환자동)
	public ModelAndView result(Model model, @ModelAttribute("model") LoginDTO dto) throws Exception {
		model.addAttribute("model2","Model 객체로부터 전달되는 값");
		ModelMap map = new ModelMap();
		map.addAttribute("model3","ModelMap 객체로부터 전달되는 값");
		map.addAttribute("model4","ModelMap 객체로부터 전달되는 값");
	
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(map);
		
		mv.addObject("model5","ModelAndView 객체로부터 전달되는 값");
		
		mv.setViewName("loginresult");
		return mv;
		}
	
//	// test5
//	@PostMapping("/login")
//	// 컨트롤러 메소드 매개변수 타입이 객체이고 요청 파라미터 이름 동일한 객체 내부의 변수 이름 자동 주입(단 매개변수 선언 타입과 같은 값 입력. 형변환자동)
//	public ModelAndView result(@ModelAttribute("model") LoginDTO dto) throws Exception {
//		// model 로 생성
//		ModelAndView mv = new ModelAndView();
//		//mv.addObject("model", dto);
//		mv.setViewName("loginresult");
//		return mv;
//		}
	
	// test4
//	@PostMapping("/login")
//	// 컨트롤러 메소드 매개변수 타입이 객체이고 요청 파라미터 이름 동일한 객체 내부의 변수 이름 자동 주입(단 매개변수 선언 타입과 같은 값 입력. 형변환자동)
//	public ModelAndView result(LoginDTO dto) throws Exception {
//		// model 로 생성
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("model", dto);
//		mv.setViewName("loginresult");
//		return mv;
//		}	
	
	// test3
//	@PostMapping("/login")
//	// 매개변수 이름 타입이 요청 파라미터 이름과 동일하지 않
//	public ModelAndView result(
//			@RequestParam(value = "id", required = false, defaultValue = "spring") String memberid, String pw) throws Exception {
//		// model 로 생성
//		LoginDTO dto = new LoginDTO();
//		dto.setId(memberid);
//		dto.setPw(pw);
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("model", dto);
//		mv.setViewName("loginresult");
//		return mv;
//		}
	// test2
//	@PostMapping("/login")
//	// 매개변수 이름 타입이 요청 파라미터 이름과 동일하면 해당 매개변수 자동 주입
//	public ModelAndView result(String id, String pw, int age) throws Exception {
//		System.out.println(age);
//		// model 로 생성
//		LoginDTO dto = new LoginDTO();
//		dto.setId(id);
//		dto.setPw(pw);
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("model", dto);
//		mv.setViewName("loginresult");
//		return mv;
//		}
	
//	test1
//	@PostMapping("/login")
//	public ModelAndView result(HttpServletRequest request) throws Exception {
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		
//		// model 로 생성
//		LoginDTO dto = new LoginDTO();
//		dto.setId(id);
//		dto.setPw(pw);
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("model", dto);
//		mv.setViewName("loginresult");
//		return mv;
//	}
}
