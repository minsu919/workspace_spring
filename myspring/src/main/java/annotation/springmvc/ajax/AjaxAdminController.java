package annotation.springmvc.ajax;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import annotation.memberservice.MemberDTO;

@Controller
public class AjaxAdminController {
	ArrayList<MemberDTO> list =  new ArrayList<MemberDTO>();
	
	@GetMapping("/ajaxadminstart") 
	public String start(){ 
		return "ajax/admin"; 
	}
	
	@RequestMapping(value="/ajaxlisttest", produces = {"application/json;charset=utf-8"}) 
	public @ResponseBody ArrayList<MemberDTO>  ajaxlist(String id, int pw) {
		list =  new ArrayList<MemberDTO>();
		if (id.equals("admin") && pw == 1111) { 
			for (int i = 1; i <= 10; i++ ) { 
				MemberDTO dto = new MemberDTO(); 
				dto.setId("ajax" + i);  
				dto.setPw(i * 1000);  
				dto.setName("홍길동" + i); 
				dto.setPhone("010-1234-456" + i); 
				dto.setEmail("hong" + i + "@gil.dong"); 
				dto.setRegdate("2025-01-07"); 
				list.add(dto);
				} 
			} 
	return list;
	}
	
	@RequestMapping(value="/getpw/{id}", produces = {"application/json;charset=utf-8"})
	public @ResponseBody String getpw(@PathVariable("id") String id){ 
		for (MemberDTO dto : list) {
			if ((dto.getId()).equals(id)) {
				return "{\"pw\":\"" + dto.getPw() + "\"}";
			}
		}
		return "{\"pw\": \"해당아이디없음\"}";
		
	}
	
}
