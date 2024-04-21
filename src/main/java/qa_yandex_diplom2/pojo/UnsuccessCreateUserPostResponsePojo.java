package qa_yandex_diplom2.pojo;

public class UnsuccessCreateUserPostResponsePojo {
	private Boolean success;
	private String message;
	
	public UnsuccessCreateUserPostResponsePojo(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public UnsuccessCreateUserPostResponsePojo() {
		super();
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
