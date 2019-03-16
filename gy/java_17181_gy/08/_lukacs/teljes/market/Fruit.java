package market;

public class Fruit {
    private String name;
    private int price;
    
    private static Fruit cheapestFruit;
    
    private Fruit(String name, int price) {
        this.name = name;
        this.price = price;
        
        if ((cheapestFruit == null) || (price < cheapestFruit.price))
            cheapestFruit = this;
    }
    
    public static Fruit make(String name, int price) {
        if (name.length() < 2 || price <= 0 || price > 5000 || price%5 != 0) return null;
        
        int i = 0;
        while (i < name.length()) {
            if (!Character.isLetter(name.charAt(i))) return null;
            ++i;
        }
        
        return new Fruit(name, price);
    }
    
    public int getPrice() {
        return price;
    }
    
    public boolean cheaperThan(Fruit other) {
        return (price < other.price);
    }
    
    public String show() {
        if (price >= 1000)
            return String.format("%s (%d %03d Ft)", name, price/1000, price%1000);
        else
            return String.format("%s (%d Ft)", name, price);
    }
    
    public static Fruit getCheapestFruit() {
        return cheapestFruit;
    }
}
