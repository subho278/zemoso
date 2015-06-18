package StoreData;


public class StoreDataPoint {

	 private String name;
	 private String month;
	 private  String category;
	 private int sales;
	 public String getName() {
		return name;
	}
	public String getMonth() {
		return month;
	}
	public String getCategory() {
		return category;
	}
	public int getSales() {
		return sales;
	}
	public void data(String[] s){
		this.name=s[0];
		this.month=s[2];
		this.category=s[1];
		this.sales=Integer.parseInt(s[3]);
	}
	
}