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
import qa_yandex_diplom2.pojo.UnsuccessCreateUserPostResponsePojo;

public class CreateUserTest {
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
	@DisplayName("Check that user can create")
	@Description("проверка что пользователя можно создать")
	public void canCreateUserTest() {
		assertEquals(SC_OK, user.getUserCreateResponse(user.getJsonWithEmailAndPasswordAndName()).statusCode());
	}
	
	@Test
	@DisplayName("Check that can not create duplicate user")
	@Description("проверка что нельзя создать повторно пользователя с теми же учетными данными")
	public void cannotCreateDuplicateUserTest() {
		user.createUser(user.getJsonWithEmailAndPasswordAndName());
		assertEquals(CommonData.UNSUCCESS_USER_EXIST_MESSAGE,
				user.getUserCreateResponse(user.getJsonWithEmailAndPasswordAndName()).as(UnsuccessCreateUserPostResponsePojo.class).getMessage());
	}
	
	@Test
	@DisplayName("Check that can not create user without email")
	@Description("проверка что нельзя создать пользователя без лолина")
	public void cannotCreateUserWithoutEmailTest() {
		assertEquals(CommonData.UNSUCCESS_EMPTY_FIELD_MESSAGE,
				user.getUserCreateResponse(user.getJsonWithoutEmailWithPasswordAndName()).as(UnsuccessCreateUserPostResponsePojo.class).getMessage());
	}
	
	@Test
	@DisplayName("Check that can not create user without password")
	@Description("проверка что нельзя создать пользователя без пароля")
	public void cannotCreateUserWithoutPasswordTest() {
		assertEquals(CommonData.UNSUCCESS_EMPTY_FIELD_MESSAGE,
				user.getUserCreateResponse(user.getJsonWithEmailWithoutPasswordAndName()).as(UnsuccessCreateUserPostResponsePojo.class).getMessage());
	}
	
	@Test
	@DisplayName("Check that can not create user without name")
	@Description("проверка что нельзя создать пользователя без имени")
	public void cannotCreateUserWithoutNameTest() {
		assertEquals(CommonData.UNSUCCESS_EMPTY_FIELD_MESSAGE,
				user.getUserCreateResponse(user.getJsonWithEmailAndPassworWithoutName()).as(UnsuccessCreateUserPostResponsePojo.class).getMessage());
	}

}
