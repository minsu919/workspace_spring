package movie;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {
	
	HashMap<String, Integer> moviemap = new HashMap();
	
	@RequestMapping("movielist")
	public ModelAndView start() {
		moviemap.put("영화제목1", 19);
		moviemap.put("영화제목2", 13);
		moviemap.put("영화제목3", 19);
		moviemap.put("영화제목4", 0);
		moviemap.put("영화제목5", 10);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("moviemap", moviemap);
		mv.setViewName("movielist");
		System.out.println(mv);
		return mv;
	}	
	
	@RequestMapping("moviereserve")
	public ModelAndView end(String id, String pw, int age, String[] movies) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.addObject("pw", pw);
		mv.addObject("age", age);
		mv.addObject("movies", movies);
		mv.addObject("moviemap", moviemap);
		mv.setViewName("moviereserve");
		return mv;
	}	
	
}
