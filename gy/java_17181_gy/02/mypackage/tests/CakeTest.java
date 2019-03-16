package mypackage.tests;

import cakes.Cake;
// import cakes.*;

public class CakeTest {
    public static void main(String[] args) {
        Cake cake1 = new Cake();
        cake1.coating = Cake.Coating.STRAWBERRY;
        cake1.numCandles = 79;

        Cake cake2 = Cake.createPopularCake();

        System.out.println(
            cake2.coating == Cake.Coating.VANILLA && cake1.compareTo(cake2) == 1
            ? "Sikeres tesztelés."
            : "Sikertelen tesztelés.");
    }
}