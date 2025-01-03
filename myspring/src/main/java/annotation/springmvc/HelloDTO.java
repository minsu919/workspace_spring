package annotation.springmvc;

public class HelloDTO {
	
	
	
	public HelloDTO() {
		super();
	}

	public HelloDTO(String message) {
		super();
		this.message = message;
	}

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
