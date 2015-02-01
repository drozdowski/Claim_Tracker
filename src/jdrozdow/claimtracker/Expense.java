package jdrozdow.claimtracker;

public class Expense {
	private String name;
	private String description;
	private String date = getDate();
	private float amount = 0;
	private String currency = "CAD";
	
	public Expense() {
		
		super();
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getDescription() {
		
		return description;
	}
	
	public void setDescription(String description) {
		
		this.description = description;
	}
	
	public String getDate() {
		
		return date;
	}
	
	public void setDate(String date) {
		
		this.date = date;
	}
	
	public float getAmount() {
		
		return amount;
	}
	
	public void setAmount(float e_amount) {
		
		this.amount = e_amount;
	}
	
	public String getCurrency() {
		
		return currency;
	}
	
	public void setCurrency(String currency) {
		
		this.currency = currency;
	}
	
}
