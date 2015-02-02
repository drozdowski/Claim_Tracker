package jdrozdow.claimtracker;

import java.util.ArrayList;

public class Claim {
	private String name;
	private String description;
	private String date_start;
	private String date_end;
	//list of all expense items
	ArrayList<Expense> items = new ArrayList<Expense>();
	
	
	public Claim() {
		super();
	}

	public void addItem(String e_name, String e_date, String e_description, String e_currency, float e_amount){
		
		Expense e = new Expense();
		e.setName(e_name);
		e.setDate(e_date);
		e.setDescription(e_description);
		e.setCurrency(e_currency);
		e.setAmount(e_amount);
		this.items.add(e);
		
	}
	
	public void deleteItem(int i) {
		
		this.items.remove(i);
	}
	
	public ArrayList<Expense> getItems(){
		return items;
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
	
	public String getDate_start() {
	
		return date_start;
	}
	
	public void setDate_start(String date) {
	
		this.date_start = date;
	}
	
	public String getDate_end() {
		
		return date_end;
	}
	
	public void setDate_end(String date) {
	
		this.date_end = date;
	}
	
	public String toString(){
		
		int length = items.size();
		return name + " : " + date_start + " - " + date_end + " with " + Integer.toString(length) + " expense(s).";
	}
	
	//this method will get a total of all expenses in a claim
	public String getTotal(){
		
		String total = "";
		if (items.size() == 0){
			return "None";
		}
		if (items.size() == 1) {
			total = Float.toString(items.get(0).getAmount()) + " " + items.get(0).getCurrency();
			return total;
		}
		else {
			ArrayList<String> currencies = new ArrayList<String>();
			for(int i = 0; i < items.size(); i++){
				if (currencies.contains(items.get(i).getCurrency())){
					//do nothing
				}
				else {
					currencies.add(items.get(i).getCurrency());
				}
			}
			for(int i = 0; i < currencies.size(); i++){
				float total_c = 0;
				for(int j = 0; j <items.size(); j++){
					if (items.get(j).getCurrency() == currencies.get(i)){
						total_c += items.get(j).getAmount();
					}
				}
				total += Float.toString(total_c) + currencies.get(i) + "\n";
			}
		
			
		}
		return total;
	}
}
