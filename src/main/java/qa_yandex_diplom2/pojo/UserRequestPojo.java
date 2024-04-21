package qa_yandex_diplom2.pojo;

public class UserRequestPojo {
	private String email;
	private String name;
	
	public UserRequestPojo(String email, String name) {
		super();
		this.email = email;
		this.name = name;
	}
	public UserRequestPojo() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
