package qa_yandex_diplom2.pojo;

public class CreateUserPostRequestPojo {
	private String email;
	private String password;
	private String name;
	
	public CreateUserPostRequestPojo(String email, String password, String name) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public CreateUserPostRequestPojo() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
