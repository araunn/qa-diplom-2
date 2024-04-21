package qa_yandex_diplom2;

import static org.junit.Assert.*;
import static org.apache.http.HttpStatus.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import qa_yandex_diplom2.data.CommonData;
import qa_yandex_diplom2.pojo.CreateUserPosrResponcePojo;

public class UserOrdersTest {
	OrderApi order = new OrderApi();
	UserApi user = new UserApi();
	
	@Before
	public void setUp() {
		RestAssured.baseURI = CommonData.SITE_ADRESS;
	}
	
	@After
	public void deleteUser() {
		user.deleteUser(user.getJsonWithEmailAndPasswordAndName());
	}

	@Test
	@DisplayName("Get all authurization user orders")
	@Description("Получить все заказы авторизованого пользователя")
	public void userOrdersWithAuthtest() {
		user.createUser(user.getJsonWithEmailAndPasswordAndName());
		String token = user.getUserAuthResponse(user.getJsonWithEmailAndPasswordAndName()).as(CreateUserPosrResponcePojo.class).getAccessToken();
		assertEquals(SC_OK, order.getUserOrdersAuthUserResponse(order.jsonOrderIngregirnts(), token).statusCode());
	}
	
	@Test
	@DisplayName("Get all not authurization user orders")
	@Description("получить все заказы не авторизованого пользователя")
	public void userOrdersWithoutAuthtest() {
		assertEquals(SC_UNAUTHORIZED, order.getUserOrdersResponse(order.jsonOrderIngregirnts()).statusCode());
	}

}
