package market;

import java.util.*;
import java.io.*;
import java.io.IOException;

public class Market {
	private LinkedList<Fruit> fruits;
	
	public Market(String fileName){
		fruits = new LinkedList<>();
		
		try {
			Scanner sc = new Scanner(new FileReader(fileName));
			
			while(sc.hasNextLine()){
				String line = sc.nextLine();
			
				String[] parts = line.split(",");
				
				if(parts.length != 2) continue;
				
				try {
					String name = parts[0];
					int price = Integer.parseInt(parts[1]);
					
					Fruit newFruit = Fruit.make(name, price);
					if( null != newFruit)
						fruits.add(newFruit);
					
				} catch(NumberFormatException e2){
					
				}
				
				
			}
			
			
		} catch(IOException e){
			e.printStackTrace();
		}
		
		System.out.println(fruits);		
	}
	

	
	public Fruit buyCheapestFruit(){
		int REALLY_BIG_INT = 80000;
		int minPrice = REALLY_BIG_INT;
		Fruit minVal = null; 
		
		for(Fruit f : fruits){
			if(f.getPrice() < minPrice){
				minVal = f;
				minPrice = f.getPrice();
			}
		}		
		
		if(minVal != null){
			fruits.remove(minVal);
		}
		
		return minVal;				
	}
	
	
	public List<Fruit> sale(){
		LinkedList<Fruit> sold = new LinkedList<>();
		
		while(! fruits.isEmpty()){
			sold.add(buyCheapestFruit());					
		}
		
		return sold;
	} 
	
	
	
	
}
