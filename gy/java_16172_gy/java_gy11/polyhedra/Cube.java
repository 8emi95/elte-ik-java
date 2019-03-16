/*
3. Hozzuk létre az előbbi Prism osztály leszármazottjaként a (konkrét) Cylinder osztályt, mellyel hengereket, továbbá egy Cube osztályt, mellyel kockákat tudunk reprezentálni!
a) Valósítsuk meg az absztrakt area() és toString() metódusokat!
b) Tiltsuk meg a Cube osztályból való származtatást!
*/

package polyhedra;

public class Cube extends Prism {
    private double side;

    public Cube(double side) {
        super(side);
        this.side = side;
    }

    public doube area() {
        return side * side;
    }

    public String toString() {
        return String.format("Cube(%5.2f)", side);
    }
}