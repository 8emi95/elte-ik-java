package mypackage.cakes;

public class Cake {
/*
    primitív típusok:
    egész típusok: byte, short, int, long
    lebegőpontos: float, double
    char, boolean

    összetett típusok (osztályok, referenciatípusok):
    - felsorolásos: public enum RgbColor { RED, GREEN, BLUE }
    - szorzattípusok (osztályok): public class Point { int x; int y; }
    - összegtípusok (unió): Javaban nincs!
*/

    public static enum Coating { VANILLA, CHOCOLATE, STRAWBERRY };

    public int numCandles;
    public Coating coating;

    public static final double PI = Math.PI;

    public int compareTo(Cake cake) {
        // int numCandles = 89; // másik numCandles már
        if (this.numCandles < cake.numCandles) {
            return -1;
        } else if (this.numCandles > cake.numCandles) {
            return 1;
        } else {
            return 0;
        }
    }

    public static Cake createPopularCake() {
        Cake cake = new Cake();
        cake.numCandles = 17;
        cake.coating = Coating.VANILLA;

        cake.compareTo(new Cake());

        double x = cake.PI;

        return cake;
    }

/*    public static void main(String[] args) {
        Cake cake1 = new Cake();
        cake1.coating = Cake.Coating.STRAWBERRY;
        cake1.numCandles = 79;

        Cake cake2 = Cake.createPopularCake();

        System.out.println(
            cake2.coating == Cake.Coating.VANILLA && cake1.compareTo(cake2) == 1
            ? "Sikeres tesztelés."
            : "Sikertelen tesztelés.");
    }*/
}