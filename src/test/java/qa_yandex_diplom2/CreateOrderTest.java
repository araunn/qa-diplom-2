package qa_yandex_diplom2;

import static org.junit.Assert.*;

import org.junit.After;

import static org.apache.http.HttpStatus.*;
import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import qa_yandex_diplom2.data.CommonData;
import qa_yandex_diplom2.pojo.CreateOrderPosrResponsePojo;
import qa_yandex_diplom2.pojo.CreateUserPosrResponcePojo;

public class CreateOrderTest {
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
	@DisplayName("Check that can create order not authurization user")
	@Description("Создание заказа не авторизованым пользователем")
	public void CreateOrderNotAuthUserTest() {
		assertTrue(order.getOrderCreateResponse(order.jsonOrderIngregirnts()).as(CreateOrderPosrResponsePojo.class).getSuccess());
	}
	
	@Test
	@DisplayName("Check that cannot create order without ingregients not authurization user")
	@Description("Проверка невозможности создание заказа без ингредиентов не авторизованым пользователем")
	public void CreateOrderWithoutIngregientsNotAuthUserTest() {
		assertEquals(SC_BAD_REQUEST,order.getOrderCreateResponse(order.jsonOrderWithoutIngregirnts()).getStatusCode());
	}
	
	@Test
	@DisplayName("Check that cannot create order with wrong ingregients not authurization user")
	@Description("Проверка невозможности создание заказа с не корректным ингредиентами не авторизованым пользователем")
	public void CreateOrderWithWrongIngregientsNotAuthUserTest() {
		assertEquals(SC_INTERNAL_SERVER_ERROR,order.getOrderCreateResponse(order.jsonOrderWithWromgIngregirnts()).getStatusCode());
	}
	
	@Test
	@DisplayName("Check that can create order with ingregients when user is authurization")
	@Description("\"Создание заказа авторизованым пользователем\"")
	public void CreateOrderWithIngregientsAuthUserTest() {
		user.createUser(user.getJsonWithEmailAndPasswordAndName());
		String token = user.getUserAuthResponse(user.getJsonWithEmailAndPasswordAndName()).as(CreateUserPosrResponcePojo.class).getAccessToken();
		assertEquals(SC_OK, order.getOrderCreateAuthUserResponse(order.jsonOrderIngregirnts(),token).statusCode());
	}
	
	@Test
	@DisplayName("Check that can create order with ingregients when user is authurization")
	@Description("Проверка невозможности создание заказа без ингредиентов авторизованым пользователем")
	public void CreateOrderWithoutIngregientsAuthUserTest() {
		user.createUser(user.getJsonWithEmailAndPasswordAndName());
		String token = user.getUserAuthResponse(user.getJsonWithEmailAndPasswordAndName()).as(CreateUserPosrResponcePojo.class).getAccessToken();
		assertEquals(SC_BAD_REQUEST, order.getOrderCreateAuthUserResponse(order.jsonOrderWithoutIngregirnts(),token).statusCode());
	}
	
	@Test
	@DisplayName("Check that can create order with ingregients when user is authurization")
	@Description("Проверка невозможности создание заказа с не корректным ингредиентами авторизованым пользователем")
	public void CreateOrderWithWrongIngregientsAuthUserTest() {
		user.createUser(user.getJsonWithEmailAndPasswordAndName());
		String token = user.getUserAuthResponse(user.getJsonWithEmailAndPasswordAndName()).as(CreateUserPosrResponcePojo.class).getAccessToken();
		assertEquals(SC_INTERNAL_SERVER_ERROR, order.getOrderCreateAuthUserResponse(order.jsonOrderWithWromgIngregirnts(),token).statusCode());
	}

}
