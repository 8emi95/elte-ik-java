/* GY4
2. Készítsünk egy util csomagban található IntList osztályt, mely egészekből álló listát valósít meg tömbbel! Legyen
a) Egy egészeket tartalmazó tömb adattagja.
b) Egy konstruktora, mely nem vár paramétert.
c) Egy konstruktora, mely egy másik IntList-et vár paraméterül. A paraméterbeli tömböt használjuk inicializálásra, a tartalmát le kell másolni elemről-elemre.

Az IntList mérete mindig pont akkora, hogy el tudja tárolni a számokat. Tehát add() hatására megnő eggyel, míg remove() hatására összemegy eggyel. Az új, nagyobb vagy kisebb tömb előállításához használjuk a java.utils.Arrays.copyOf() statikus metódust!

Az IntList rendelkezzen az alábbi metódusokkal:
a) size(), mely megadja az eltárolt egészek számát.
b) get(), mely visszaadja az első számot.
c) get(), mely visszaadja az adott indexen tárolt egész számot (túlterhelt változat).
d) add(), mely egy egész számot szúr be a lista végére.
e) add(), mely egy egész számot egy megadott pozícióra szúr be (túlterhelt változat).
f) toString(), mely szöveggé alakítja a listát. Az elemek vesszővel elválasztva szerepelnek a szövegben.
fromString() statikus metódus, mely szövegből készít listát. A szövegben a számokat szóközzel elválasztva adjuk meg. Amennyiben nem sikerült a számok kiolvasása a szövegből, adjunk vissza  null-t. Például jó paraméter az 1 3 5 szöveg.
*/

package util;

import java.util.Arrays;

public class IntList {
	private int[] ns;

	public IntList() {
		ns = new int[0]; // ns = null (nem nullreferencia) ns.length; lekérdezése ??? NullpointerException
	}

	public IntList(int[] numbers) {
		ns = Arrays.copyOf(numbers, numbers.length);
	}

	public int get() {
		return ns[0];
	}

	public int get(int index) {
		return ns[index];
	}
}