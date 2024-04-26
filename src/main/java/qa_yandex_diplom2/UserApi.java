package qa_yandex_diplom2;

import static org.apache.http.HttpStatus.*;
import io.restassured.response.Response;
import qa_yandex_diplom2.data.CommonData;
import qa_yandex_diplom2.pojo.CreateUserPosrResponcePojo;
import qa_yandex_diplom2.pojo.CreateUserPostRequestPojo;

import static io.restassured.RestAssured.given;

public class UserApi {
	
	public Response getUserCreateResponse(CreateUserPostRequestPojo json) {
		return given().header("Content-type", "application/json").body(json).when().post(CommonData.CREATE_USER_API);
	}
	
	public Response getUserAuthResponse(CreateUserPostRequestPojo json) {
		return given().header("Content-type", "application/json").body(json).when().post(CommonData.AUTHORIZATION_USER_API);
	}
	
	public Response getUserChangeResponse (CreateUserPostRequestPojo json, String token) {
		return given().header("Content-type", "application/json").header("Authorization", token).body(json).when().patch(CommonData.CHANGE_USER_API);
	}
	
	public void createUser(CreateUserPostRequestPojo json) {
		given().header("Content-type", "application/json").body(json).when().post(CommonData.CREATE_USER_API).then().statusCode(SC_OK);
	}
	
	public void deleteUser(CreateUserPostRequestPojo json) {
		CreateUserPosrResponcePojo response = given().header("Content-type", "application/json").body(json).when().post(CommonData.AUTHORIZATION_USER_API)
				.then().extract().as(CreateUserPosrResponcePojo.class);
		if (response.getSuccess()) {
			given().header("Authorization", response.getAccessToken()).delete(CommonData.DELETE_USER_API).then().statusCode(SC_ACCEPTED);
		}
	}
	
	public CreateUserPostRequestPojo getJsonWithEmailAndPasswordAndName() {
		return new CreateUserPostRequestPojo(CommonData.USER_EMAIL, CommonData.USER_PASSWORD, CommonData.USER_NAME);
	}
	
	public CreateUserPostRequestPojo getJsonWithoutEmailWithPasswordAndName() {
		return new CreateUserPostRequestPojo(CommonData.EMPTY_STRING, CommonData.USER_PASSWORD_NEW, CommonData.USER_NAME_NEW);
	}
	
	public CreateUserPostRequestPojo getJsonWithEmailWithoutPasswordAndName() {
		return new CreateUserPostRequestPojo(CommonData.USER_EMAIL_NEW, CommonData.EMPTY_STRING, CommonData.USER_NAME_NEW);
	}
	
	public CreateUserPostRequestPojo getJsonWithEmailAndPassworWithoutName() {
		return new CreateUserPostRequestPojo(CommonData.USER_EMAIL_NEW, CommonData.USER_PASSWORD_NEW, CommonData.EMPTY_STRING);
	}
	
	public CreateUserPostRequestPojo getJsonWithWrongEmailWithPasswordAndName() {
		return new CreateUserPostRequestPojo(CommonData.USER_EMAIL_NEW, CommonData.USER_PASSWORD, CommonData.USER_NAME);
	}
	
	public CreateUserPostRequestPojo getJsonWithEmailWithWrongPasswordAndName() {
		return new CreateUserPostRequestPojo(CommonData.USER_EMAIL, CommonData.USER_PASSWORD_NEW, CommonData.USER_NAME);
	}
	
	public CreateUserPostRequestPojo getJsonWithEmailAndPasswordWithWrongName() {
		return new CreateUserPostRequestPojo(CommonData.USER_EMAIL, CommonData.USER_PASSWORD, CommonData.USER_NAME_NEW);
	}

}
