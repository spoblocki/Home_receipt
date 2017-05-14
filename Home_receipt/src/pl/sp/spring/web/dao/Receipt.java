package pl.sp.spring.web.dao;

public class Receipt {
	private int id;
	private String description;
	private String company;
	private String date;
	private double price;

	public Receipt() {

	}

	public Receipt(String description, String company, String date, double price) {

		this.description = description;
		this.company = company;
		this.date = date;
		this.price = price;
	}

	public Receipt(int id, String description, String company, String date, double price) {
		super();
		this.id = id;
		this.description = description;
		this.company = company;
		this.date = date;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Receipt [id=" + id + ", description=" + description + ", company=" + company + ", date=" + date
				+ ", price=" + price + "]";
	}

}
