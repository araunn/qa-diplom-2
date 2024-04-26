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
import qa_yandex_diplom2.pojo.ChangeUserPutchResponsePojo;
import qa_yandex_diplom2.pojo.CreateUserPosrResponcePojo;

public class ChangeUserTest {
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
	@DisplayName("Check what can change email in user data at authorization user")
	@Description("проверка что можно поменять логин авторизованого пользователя")
	public void changeUserWithAuthWithNewEmailTest() {
		String token = user.getUserAuthResponse(user.getJsonWithEmailAndPasswordAndName()).as(CreateUserPosrResponcePojo.class).getAccessToken();
		assertTrue(user.getUserChangeResponse(user.getJsonWithWrongEmailWithPasswordAndName(),token).as(ChangeUserPutchResponsePojo.class).getSuccess());
		user.getUserChangeResponse(user.getJsonWithEmailAndPasswordAndName(), token);
	}
	
	@Test
	@DisplayName("Check what can change password in user data at authorization user")
	@Description("проверка что можно поменять пароль авторизованого пользователя")
	public void changeUserWithAuthWithNewPasswordTest() {
		String token = user.getUserAuthResponse(user.getJsonWithEmailAndPasswordAndName()).as(CreateUserPosrResponcePojo.class).getAccessToken();
		assertTrue(user.getUserChangeResponse(user.getJsonWithEmailWithWrongPasswordAndName(),token).as(ChangeUserPutchResponsePojo.class).getSuccess());
		user.getUserChangeResponse(user.getJsonWithEmailAndPasswordAndName(), token);
	}

	@Test
	@DisplayName("Check what can change name in user data at authorization user")
	@Description("проверка что можно поменять имя авторизованого пользователя")
	public void changeUserWithAuthWithNewNameTest() {
		String token = user.getUserAuthResponse(user.getJsonWithEmailAndPasswordAndName()).as(CreateUserPosrResponcePojo.class).getAccessToken();
		assertTrue(user.getUserChangeResponse(user.getJsonWithEmailAndPasswordWithWrongName(),token).as(ChangeUserPutchResponsePojo.class).getSuccess());
		user.getUserChangeResponse(user.getJsonWithEmailAndPasswordAndName(), token);
	}
	
	@Test
	@DisplayName("Check what cannot change email in user data at not authorization user")
	@Description("проверка что нельзя поменять логин не авторизованого пользователя")
	public void changeUserWithoutAuthWithNewEmailTest() {
		assertEquals(SC_UNAUTHORIZED, user.getUserChangeResponse(user.getJsonWithWrongEmailWithPasswordAndName(),CommonData.EMPTY_STRING).getStatusCode());
	}
	
	@Test
	@DisplayName("Check what cannot change password in user data at not authorization user")
	@Description("проверка что нельзя поменять пароль не авторизованого пользователя")
	public void changeUserWithoutAuthWithNewPasswordTest() {
		assertEquals(SC_UNAUTHORIZED, user.getUserChangeResponse(user.getJsonWithEmailWithWrongPasswordAndName(),CommonData.EMPTY_STRING).getStatusCode());
	}
	
	@Test
	@DisplayName("Check what cannot change name in user data at not authorization user")
	@Description("проверка что нельзя поменять имя не авторизованого пользователя")
	public void changeUserWithoutAuthWithNewNameTest() {
		assertEquals(SC_UNAUTHORIZED, user.getUserChangeResponse(user.getJsonWithEmailAndPasswordWithWrongName(),CommonData.EMPTY_STRING).getStatusCode());
	}
}
