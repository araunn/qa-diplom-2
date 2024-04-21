package qa_yandex_diplom2;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;

import io.restassured.response.Response;
import qa_yandex_diplom2.data.CommonData;
import qa_yandex_diplom2.pojo.CreateOrderPostRequestPojo;

public class OrderApi {
	
	public Response getOrderCreateResponse(CreateOrderPostRequestPojo json) {
		return given().header("Content-type", "application/json").body(json).when().post(CommonData.CREATE_ORDER_API);
	}
	
	public Response getOrderCreateAuthUserResponse(CreateOrderPostRequestPojo json, String token) {
		return given().header("Content-type", "application/json").header("Authorization", token).body(json).when().post(CommonData.CREATE_ORDER_API);
	}
	
	public Response getUserOrdersResponse(CreateOrderPostRequestPojo json) {
		return given().header("Content-type", "application/json").when().get(CommonData.USER_ORDERS_API);
	}
	
	public Response getUserOrdersAuthUserResponse(CreateOrderPostRequestPojo json, String token) {
		return given().header("Content-type", "application/json").header("Authorization", token).when().get(CommonData.USER_ORDERS_API);
	}
	
	public void createUser(CreateOrderPostRequestPojo json) {
		given().header("Content-type", "application/json").body(json).when().post(CommonData.CREATE_ORDER_API).then().statusCode(SC_OK);
	}
	
	public CreateOrderPostRequestPojo jsonOrderIngregirnts() {
		return new CreateOrderPostRequestPojo(CommonData.INGREGIENTS);
	}
	
	public CreateOrderPostRequestPojo jsonOrderWithoutIngregirnts() {
		return new CreateOrderPostRequestPojo(CommonData.WITHOUT_INGREGIENTS);
	}
	
	public CreateOrderPostRequestPojo jsonOrderWithWromgIngregirnts() {
		return new CreateOrderPostRequestPojo(CommonData.WRONG_INGREGIENTS);
	}

}
