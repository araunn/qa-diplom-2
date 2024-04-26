package qa_yandex_diplom2.pojo;

public class ChangeUserPutchResponsePojo {
	private Boolean success;
	private UserRequestPojo user;
	
	public ChangeUserPutchResponsePojo(Boolean success, UserRequestPojo user) {
		super();
		this.success = success;
		this.user = user;
	}

	public ChangeUserPutchResponsePojo() {
		super();
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public UserRequestPojo getUser() {
		return user;
	}

	public void setUser(UserRequestPojo user) {
		this.user = user;
	}
	
	

}
