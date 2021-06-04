package product;
import java.io.Serializable;

public class Coupon implements Serializable{

	private String category;
	private String brand;
	private String product;
	private int price;
	
	public Coupon(){
		
	}
	
	public Coupon(String product) {
		this.product=product;
	}
	public Coupon(String product, int price) {
		this.product=product;
		this.price=price;
	}
	
	public Coupon(String brand,String product) {
		this.brand=brand;
		this.product=product;
	}
	
	public Coupon(String category,String brand,String product) {
		this.category=category;
		this.brand=brand;
		this.product=product;
	}
	
	public Coupon(String category,String brand,String product,int price) {
		this.category=category;
		this.brand=brand;
		this.product=product;
		this.price=price;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

	
	
}
