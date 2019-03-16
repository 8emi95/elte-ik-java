import market.*;

public class Main {
    public static void main(String[] args) {
        if( args.length != 1 ) {
            System.out.println("Hasznalat: Main inputfajl");
            System.exit(1);
        }
        
        Market market = new Market(args[0]);
        
        for( Fruit fruit : market.sale() ) {
            System.out.println(fruit.show());
        }
    }
}
