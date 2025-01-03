package nonspring;

import java.util.HashMap;

public class HandlerMapping {
	
	HashMap<String, Controller> mappings;
	
	HandlerMapping(){
		mappings = new HashMap();
		mappings.put("hello", new HelloController());
		mappings.put("list", new ListController());
	}
	
	Controller getController(String url){
		return mappings.get(url);	
	}
}
