package qa_yandex_diplom2.data;

public class CommonData {
	public static final String SITE_ADRESS = "https://stellarburgers.nomoreparties.site/";
	public static final String CREATE_USER_API = "api/auth/register";
	public static final String AUTHORIZATION_USER_API = "api/auth/login";
	public static final String DELETE_USER_API = "api/auth/user";
	public static final String CHANGE_USER_API = "api/auth/user";
	public static final String CREATE_ORDER_API = "api/orders";
	public static final String USER_ORDERS_API = "api/orders";
	
	  public static final String USER_EMAIL= "ino@yandex.ru";
	  public static final String USER_EMAIL_NEW = "Ino1@yandex.ru";
	  public static final String USER_PASSWORD = "1234";
	  public static final String USER_PASSWORD_NEW = "12345";
	  public static final String USER_NAME = "InoGuest";
	  public static final String USER_NAME_NEW= "Mr. no name";
	  public static final String EMPTY_STRING = "";
	  public static final Boolean SUCCESS_CREATE_USER_MESSAGE = true;
	  public static final String UNSUCCESS_USER_EXIST_MESSAGE = "User already exists";
	  public static final String UNSUCCESS_EMPTY_FIELD_MESSAGE = "Email, password and name are required fields";
	  public static final String UNSUCCESS_AUTH_MESSAGE = "email or password are incorrect";
	  public static final String UNSUCCESS_CHANGE_MESSAGE = "User with such email already exists";
	  public static final String[] INGREGIENTS = {"61c0c5a71d1f82001bdaaa6d","61c0c5a71d1f82001bdaaa71","61c0c5a71d1f82001bdaaa74","61c0c5a71d1f82001bdaaa6d"};
	  public static final String[] WITHOUT_INGREGIENTS = {};
	  public static final String[] WRONG_INGREGIENTS = {"Какая-то булка", "Мясо, что я принес с собой", "Вчерашний соус", "Без нижней булки, просто положи на руку"};
}
