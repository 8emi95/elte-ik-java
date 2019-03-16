/*
2. Hozzunk létre egy absztrakt polyhedra.Prism osztályt, amely segítségével hasábokat tudunk ábrázolni!
a) Tároljuk el benne a hasáb magasságát (height), valamint legyen egy olyan absztrakt metódus, amely az alapterületét számolja ki (area()). Ennek felhasználásával aztán készítsünk egy másik, nem felüldefiniálható metódust, amely a hasáb térfogatát számítja ki a magasság és az alapterület segítségével (volume()).
b) Tegyük absztrakttá a toString() metódust, hogy a leszármazottban kötelező legyen megvalósítani!
c) Definiáljuk felül az equals() metódust! Az egyenlőséget a térfogat alapján vizsgáljuk.
*/

package polyhedra;

public abstract class Prism {
    private double height;

    public Prism(double height, double size) {
        this.height = height;
        this.size = size;
    }

    public double getHeight() {
        return height;
    }

    public abstract double area();

    public double volume() {
        return area() * height;
    }
}