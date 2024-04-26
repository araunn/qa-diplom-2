package qa_yandex_diplom2.pojo;

public class CreateOrderPosrResponsePojo {
	private Boolean success;
	private String name;
	private OrderResponsePojo order;
	
	public CreateOrderPosrResponsePojo(Boolean success, String name, OrderResponsePojo order) {
		super();
		this.success = success;
		this.name = name;
		this.order = order;
	}

	public CreateOrderPosrResponsePojo() {
		super();
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OrderResponsePojo getOrder() {
		return order;
	}

	public void setOrder(OrderResponsePojo order) {
		this.order = order;
	}
	
	

}
