package javagyak2.cakes;

public class Cake {
  public enum Coatings { CHOCOLATE, STRAWBERRY, VANILLA };

  public Coatings coating;
  public int numCandles;

  public static Cake createPopularCake(){
    Cake cake = new Cake();
    cake.coating = Coatings.VANILLA;
    cake.numCandles = 17;
    return cake;
  }

  public int compareTo(Cake cake){
    if(numCandles < cake.numCandles){
      return -1;
    } else if (numCandles > cake.numCandles){
      return 1;
    } else {
      return 0;
    }
  }
}
