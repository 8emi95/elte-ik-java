import java.util.ArrayList;
import java.util.List;

import teszt.*;
import szallitas.*;

public class SzallitasTeszt {
    
    public static void main(String[] args) {
        List<Teszt> tesztek = new ArrayList<Teszt>();
        tesztek.add(new Teszt2());
        tesztek.add(new Teszt3());
        tesztek.add(new Teszt4());
        tesztek.add(new Teszt5());
        int jegy = 1;
        for (Teszt teszt : tesztek) {
            if (teszt.teszt()) {
                ++jegy;
            }
        }
        System.out.println("A jegyed valoszinuleg: " + jegy);
    }
    
}
