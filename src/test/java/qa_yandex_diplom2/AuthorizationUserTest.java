package qa_yandex_diplom2;

import static org.apache.http.HttpStatus.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import qa_yandex_diplom2.data.CommonData;

public class AuthorizationUserTest {
	UserApi user = new UserApi();

	@Before
	public void setUp() {
		RestAssured.baseURI = CommonData.SITE_ADRESS;
		user.createUser(user.getJsonWithEmailAndPasswordAndName());
	}
	
	@After
	public void deleteUser() {
		user.deleteUser(user.getJsonWithEmailAndPasswordAndName());
	}

	@Test
	@DisplayName("Check authorization user")
	@Description("проверка авторизации")
	public void canAuthUserTest() {
		assertEquals(SC_OK, user.getUserAuthResponse(user.getJsonWithEmailAndPasswordAndName()).statusCode());
	}
	
	@Test
	@DisplayName("Check what cannot authorization user with wrong email")
	@Description("проверка что нельзя авторизоваться с неверным логином")
	public void cannotAuthUserWrongEmailTest() {
		assertEquals(SC_UNAUTHORIZED, user.getUserAuthResponse(user.getJsonWithWrongEmailWithPasswordAndName()).statusCode());
	}
	
	@Test
	@DisplayName("Check what cannot authorization user with wrong password")
	@Description("проверка что нельзя авторизоваться с неверным паролем")
	public void cannotAuthUserWrongPasswordTest() {
		assertEquals(SC_UNAUTHORIZED, user.getUserAuthResponse(user.getJsonWithEmailWithWrongPasswordAndName()).statusCode());
	}

}
