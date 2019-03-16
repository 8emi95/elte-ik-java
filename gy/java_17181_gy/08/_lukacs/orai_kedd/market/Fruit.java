package market;	

public class Fruit {
	private String name;
	private int price;
	
	private  Fruit(String name, int price) {
		this.name = name;
		this.price = price;		
	}
	
	public static Fruit make(String name, int price){
		if(! (name.length() >= 2 && name.matches("[A-Za-z]+") ) )
			return null;
			
			
		if(! (price > 0 && price <= 5000 && price % 5 == 0) ) 
			return null;
			
		return new Fruit(name, price);
				
	}
	
	public int getPrice() {
		return price;
	}
	
	public boolean cheaperThan(Fruit other){
		return this.price < other.price;
	}
	
	
	public String toString(){
		return name + ":" + price;
	}
	
	
	
	
}
