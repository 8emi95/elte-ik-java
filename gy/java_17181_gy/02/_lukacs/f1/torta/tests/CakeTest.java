package javagyak2.tests;
// import javagyak2.*;  // ROSSZ!!!
// import javagyak2.cakes.*;
import javagyak2.cakes.Cake;


public class CakeTest {
  public static void main(String[] args){
    Cake cake1 = new Cake();
    cake1.coating = Cake.Coatings.STRAWBERRY;
    cake1.numCandles = 79;

    Cake cake2 = Cake.createPopularCake();

    System.out.println(
        cake2.coating == Cake.Coatings.VANILLA && cake1.compareTo(cake2)==1
        ? "Sikeres tesztelés."
        : "Sikertelen tesztelés."); 
  }
}
