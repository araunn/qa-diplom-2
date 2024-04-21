package qa_yandex_diplom2.pojo;

public class CreateOrderPostRequestPojo {
	private String[] ingredients;

	public CreateOrderPostRequestPojo(String[] ingredients) {
		super();
		this.ingredients = ingredients;
	}

	public CreateOrderPostRequestPojo() {
		super();
	}

	public String[] getIngredients() {
		return ingredients;
	}

	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}
	

}
