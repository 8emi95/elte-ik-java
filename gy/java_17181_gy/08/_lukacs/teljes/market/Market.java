package market;

import java.io.*;
import java.util.*;

public class Market {
    private LinkedList<Fruit> fruits;
    
    public Market(String filePath) {
        fruits = new LinkedList<Fruit>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
            
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] parts = line.split(",");
                if (parts.length != 2) continue;
                try {
                    Fruit fruit = Fruit.make(parts[0], Integer.parseInt(parts[1]));
                    if (fruit != null)
                        fruits.add(fruit);
                } catch (NumberFormatException e) { }
            }
        } catch (IOException e) {}
    }
    
    public int numberOfFruits() {
        return fruits.size();
    }
    
    public String show() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < fruits.size()-1; ++i)
            sb.append(fruits.get(i).show() + "\n");
        if (fruits.size() > 0)
            sb.append(fruits.get(fruits.size()-1).show());
        
        return sb.toString();
    }

    public LinkedList<Fruit> cheaperThan(Fruit fruit) {
        LinkedList<Fruit> result = new LinkedList<Fruit>();
        
        for( Fruit f : fruits )
            if( f.cheaperThan(fruit) )
                result.add(f);
        
        return result;
    }
    
    public double average() {
        if( fruits.isEmpty() ) return -1;
        
        double sum = 0;
        for( Fruit f : fruits )
            sum += f.getPrice();
        
        return sum / fruits.size();
    }
    
    public Fruit buyCheapestFruit() {
        if( fruits.isEmpty() ) return null;
        
        int cheapest = 0;
        for( int i = 1; i < fruits.size(); ++i )
            if( fruits.get(i).cheaperThan(fruits.get(cheapest)) )
                cheapest = i;
        
        return fruits.remove(cheapest);
    }
    
    public LinkedList<Fruit> sale() {
        LinkedList<Fruit> result = new LinkedList<Fruit>();
        
        while( !fruits.isEmpty() )
            result.add(buyCheapestFruit());
        
        return result;
    }
}
