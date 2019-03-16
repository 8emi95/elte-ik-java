package market;

import java.lang.*;
//import java.lang.Object;
import java.text.*;
/*import java.text.Format;
import java.text.NumberFormat;
import java.text.DecimalFormat;*/

public class Fruit{
	
	private String name;
	private int price;
	
	private Fruit(String name,int price){
		this.name = name;
		this.price = price;
	}
	
	public static Fruit make(String nameIn,int priceIn){
		int last = priceIn%10;
		if((!(nameIn.matches(".*\\d+.*")) && nameIn.length() >=2) && (( 0 <= priceIn && priceIn <= 5000) || last == 5) ){
			return new Fruit(nameIn,priceIn);
		} else {
			return null;
			
		}	
	}	

	public int getPrice(){
		return this.price;
	}
	
	public boolean cheaperThan(int priceIn){
		return this.price < priceIn;
	}
	
	public String show(){
		if(price > 1000){
			DecimalFormat newprice = new DecimalFormat("#,###");
			String output = newprice.format(price);
			return name + " " + output; 
		}
		else
			return name + " " + price;
		
	}
	
	/*public String cheapestFruit(){
		
		//for(int i = 0;i < )
			if(){
			Fruit fruit2 = new Fruit(name,price);
		} else 
			return null;
	}*/
	
	/*public static void getCheapestFruit(){
		return Fruit.fruit2;	
	}*/
}