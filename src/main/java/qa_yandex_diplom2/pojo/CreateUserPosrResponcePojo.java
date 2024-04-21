package qa_yandex_diplom2.pojo;

public class CreateUserPosrResponcePojo {
	private Boolean success;
	private UserRequestPojo user;
	private String accessToken;
	private String refreshToken;
	
	public CreateUserPosrResponcePojo(Boolean success, UserRequestPojo user, String accessToken, String refreshToken) {
		super();
		this.success = success;
		this.user = user;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public CreateUserPosrResponcePojo() {
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

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	

}
