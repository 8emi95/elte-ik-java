import java.util.List;
import market.Market;
import market.Fruit;

public class Main {
	public static void main(String[] args){
		
		if(args.length == 0) {
			System.out.println("args.length == 0");			
			return;
		}
		
		Market m = new Market(args[0]);
		
		// TODO
		List<Fruit> fruits = m.sale();
		
		System.out.println(fruits);		
							
	}
}
