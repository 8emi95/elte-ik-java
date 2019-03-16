package verseny;
import verseny.Versenyzo;

class Verseny {
	String nev;
	// A versenynek legyen egy nev adattagja (szöveg) és tartsuk számon, kik a versenyzok (Versenyzo?k tömbje).
	
	Verseny(String fajlnev) {
		//
	}
	// A konstruktora egy fájlnevet kap szövegesen paraméterként.
	// Feltételezhető, hogy a fájl létezik, és helyesen van kitöltve:
	//		az első sorában tartalmazza a verseny nevét,
	//		a másodikban a benne található versenyzők számát,
	//		a fennmaradó sorokban pedig egy-egy versenyző adatait.
	//		A versenyzők adatai olyan alakúak, ahogyan azt a Versenyzo második konstruktora elvárja.
	// A Verseny konstruktora olvassa be a fájl adatait, és töltse fel az adattagokat.
	
	String toString() {
		//
	}
	// A példaként adott verseny1.txt fájlban leírt verseny adja az alábbi kimenetet:
	// "Verseny:(Verseny1, Versenyzo[Versenyzo1, [versenyA, versenyB, versenyC, versenyD]], Versenyzo[Versenyzo2, [versenyA, versenyE]], Versenyzo[Versenyzo3, [versenyB, versenyC, versenyF]])"
	
	getVersenyVersenyzoi(String versenyNev) {
		//
	}
	// Legyen egy getVersenyVersenyzoi művelete. Ez szövegesen megkapja egy verseny nevét, és azokat a versenyzőket adja vissza egy List listában, akik részt vettek ilyen nevű versenyen.
}