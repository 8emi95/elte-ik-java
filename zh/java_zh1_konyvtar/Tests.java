import java.util.Arrays;
import java.util.List;

import konyvtar.Konyv;
import konyvtar.Konyvtar;

public class Tests {
	private static int points = 0;
	
	public static void main(String[] args) throws Exception {
		scoreKonyvKonstruktorSokKonyvvel(2);
		scoreKonyvKonstruktorEsGetter(6);
		scoreKonyvKonstruktorEnkapszulalt(2);
		scoreJavaKonyv(2);
		scoreKonyvGetterEnkapszulalt(2);
		scoreKonyvSetter(4);
		scoreKonyvSetterEnkapszulalt(2);
		scoreKonyvKonstruktorEgyetlenSzoveg(2);
		scoreKonyvToString(5);
		scoreKonyvHasKategoria(4);

		scoreKonyvtarKonstruktor(6);
		scoreGetKategoriaKonyvei(4);

		System.out.println("Elert pontszam: " + points);
	}

	private static void scoreJavaKonyv(int points) {
		assertEquals("A javaKonyv címe nem az elvárt.", "Java", Konyv.javaKonyv.getCim());
		assertEquals("A javaKonyv nem megfelelő számú kategóriával rendelkezik", 2, Konyv.javaKonyv.getKategoriak().length);
		assertEquals("A javaKonyv nem rendelkezik a 'java' kategóriával", "java", Konyv.javaKonyv.getKategoriak()[0]);
		assertEquals("A javaKonyv nem rendelkezik a 'programozas' kategóriával", "programozas", Konyv.javaKonyv.getKategoriak()[1]);
		Tests.points += points;
	}

	private static void scoreKonyvKonstruktorEgyetlenSzoveg(int points) {
		Konyv konyv = new Konyv("KonyvCime,kat1,kat2");

		assertEquals("A Konyv vesszős-szöveges konstruktora hibás lehet: a kapott könyv címe helytelen", "KonyvCime", konyv.getCim());
		assertTrue("A Konyv vesszős-szöveges konstruktora hibás lehet: a kapott könyvnek nincsen meg egy elvárt kategóriája ", konyv.hasKategoria("kat1"));
		assertTrue("A Konyv vesszős-szöveges konstruktora hibás lehet: a kapott könyvnek nincsen meg egy elvárt kategóriája", konyv.hasKategoria("kat2"));
		assertTrue("A Konyv vesszős-szöveges konstruktora hibás lehet: a kapott könyvnek nem elvárt kategóriája van", !konyv.hasKategoria("kat3"));
		Tests.points += points;
	}

	private static void scoreGetKategoriaKonyvei(int points) throws Exception {
		Konyvtar konyvtar = new Konyvtar("konyvtar1.txt");

		assertTrue("A konyvtar1.txt könyvtárának getKategoriaKonyvei() művelete eredményében benne van a nem várt 'nincs ilyen'.", konyvtar.getKategoriaKonyvei("nincs ilyen").isEmpty());
		List<Konyv> katA = konyvtar.getKategoriaKonyvei("katA");
		assertEquals("A konyvtar1.txt könyvtárának getKategoriaKonyvei() művelete 'katA' paraméterre nem megfelelő hosszú listát ad.", 2, katA.size());
		List<Konyv> katB = konyvtar.getKategoriaKonyvei("katB");
		assertEquals("A konyvtar1.txt könyvtárának getKategoriaKonyvei() művelete 'katB' paraméterre nem megfelelő hosszú listát ad.", 2, katB.size());
		List<Konyv> katC = konyvtar.getKategoriaKonyvei("katC");
		assertEquals("A konyvtar1.txt könyvtárának getKategoriaKonyvei() művelete 'katC' paraméterre nem megfelelő hosszú listát ad.", 2, katC.size());
		List<Konyv> katD = konyvtar.getKategoriaKonyvei("katD");
		assertEquals("A konyvtar1.txt könyvtárának getKategoriaKonyvei() művelete 'katD' paraméterre nem megfelelő hosszú listát ad.", 1, katD.size());
		List<Konyv> katE = konyvtar.getKategoriaKonyvei("katE");
		assertEquals("A konyvtar1.txt könyvtárának getKategoriaKonyvei() művelete 'katE' paraméterre nem megfelelő hosszú listát ad.", 1, katE.size());
		List<Konyv> katF = konyvtar.getKategoriaKonyvei("katF");
		assertEquals("A konyvtar1.txt könyvtárának getKategoriaKonyvei() művelete 'katF' paraméterre nem megfelelő hosszú listát ad.", 1, katF.size());

		Konyv k1 = katD.get(0);
		assertTrue("konyvtar1.txt: A getKategoriaKonyvei('katA') eredményében nem szerepel az elvárt 'Nev1' nevű könyv.", katA.contains(k1));
		assertTrue("konyvtar1.txt: A getKategoriaKonyvei('katB') eredményében nem szerepel az elvárt 'Nev1' nevű könyv.", katB.contains(k1));
		assertTrue("konyvtar1.txt: A getKategoriaKonyvei('katC') eredményében nem szerepel az elvárt 'Nev1' nevű könyv.", katC.contains(k1));
		assertTrue("konyvtar1.txt: A getKategoriaKonyvei('katD') eredményében nem szerepel az elvárt 'Nev1' nevű könyv.", katD.contains(k1));
		assertTrue("konyvtar1.txt: A getKategoriaKonyvei('katE') eredményében szerepel a nem várt 'Nev1' nevű könyv.", !katE.contains(k1));
		assertTrue("konyvtar1.txt: A getKategoriaKonyvei('katF') eredményében szerepel a nem várt 'Nev1' nevű könyv.", !katF.contains(k1));
		Tests.points += points;
	}

	private static void scoreKonyvtarKonstruktor(int points) throws Exception {
		Konyvtar konyvtar = new Konyvtar("konyvtar1.txt");

		assertEquals("A konyvtar1.txt fájlból vett Konyvtar toString-je nem az elvárt eredményt adja.",
				"Konyvtar:(Kvt1, Konyv[Nev1, [katA, katB, katC, katD]], Konyv[Nev2, [katA, katE]], Konyv[Nev3, [katB, katC, katF]])",
				konyvtar.toString());
		Tests.points += points;
	}

	private static void scoreKonyvHasKategoria(int points) {
		Konyv konyv = new Konyv("KonyvCime", new String[] { "kat1", "kat2" });

		assertTrue("A Konyvtar hasKategoria() műveletének eredményében nem szerepel egy elvárt érték.", konyv.hasKategoria("kat1"));
		assertTrue("A Konyvtar hasKategoria() műveletének eredményében nem szerepel egy elvárt érték.", konyv.hasKategoria("kat2"));
		assertTrue("A Konyvtar hasKategoria() műveletének eredményében szerepel egy nem várt érték.", !konyv.hasKategoria("kat3"));
		Tests.points += points;
	}

	private static void scoreKonyvToString(int points) {
		Konyv konyv = new Konyv("KonyvCime", new String[] { "kat1", "kat2" });

		assertEquals("A konyv toString()-jének eredménye eltér az elvárttól.", "Konyv[KonyvCime, [kat1, kat2]]", konyv.toString());
		Tests.points += points;
	}

	private static void scoreKonyvKonstruktorSokKonyvvel(int points) {
		String[] kategoriak = new String[10000];
		for (int i = 0; i < kategoriak.length; i++) {
			kategoriak[i] = "";
		}

		new Konyv("Sokkonyv", kategoriak);
		Tests.points += points;
	}

	private static void scoreKonyvSetterEnkapszulalt(int points) {
		Konyv konyv = new Konyv("KonyvCime", new String[] { "kat1", "kat2" });
		String[] ujKategoriak = new String[] { "kat3", "kat4" };
		konyv.setKategoriak(ujKategoriak);

                ujKategoriak[0] = "átírtam";

		assertEquals("A Konyv setKategoriak művelete nem megfelelően enkapszulált (kiszivárog a belső tömb).", "[kat3, kat4]", Arrays.toString(konyv.getKategoriak()));
		Tests.points += points;
	}

	private static void scoreKonyvGetterEnkapszulalt(int points) {
     		Konyv konyv = new Konyv("KonyvCime", new String[] { "kat1", "kat2" });
		konyv.getKategoriak()[0] = "átírtam";

		assertEquals("A Konyv getKategoriak művelete nem megfelelően enkapszulált (kiszivárog a belső tömb).", "[kat1, kat2]", Arrays.toString(konyv.getKategoriak()));
		Tests.points += points;
	}

	private static void scoreKonyvKonstruktorEnkapszulalt(int points) {
		String[] kategoriak = new String[] { "kat1", "kat2" };
		Konyv konyv = new Konyv("KonyvCime", kategoriak);
    		kategoriak[0] = "átírtam";

		assertEquals("A Konyv konstruktora nem megfelelően enkapszulált (kiszivárog a belső tömb).", "[kat1, kat2]", Arrays.toString(konyv.getKategoriak()));
		Tests.points += points;
	}

	private static void scoreKonyvSetter(int points) {
		Konyv konyv = new Konyv("KonyvCime", new String[] { "kat1", "kat2" });

		konyv.setCim("UjCim");
		konyv.setKategoriak(new String[] { "kat3", "kat4" });

		assertEquals("A könyv címének settere alighanem hibás: a getCim() művelete nem megfelelő eredményt ad.", konyv.getCim(), "UjCim");
		assertEquals("A könyv kategóriáinak settere alighanem hibás: a getKategoriak() művelete nem megfelelő eredményt ad.", Arrays.toString(konyv.getKategoriak()), "[kat3, kat4]");
		Tests.points += points;
	}

	private static void scoreKonyvKonstruktorEsGetter(int points) {
		String[] kategoriak = new String[] { "kat1", "kat2" };
		Konyv konyv = new Konyv("KonyvCime", kategoriak);

		assertEquals("A könyv konstruktora és/vagy gettere alighanem hibás: a getCim() művelete nem megfelelő eredményt ad.", konyv.getCim(), "KonyvCime");
		assertEquals("A könyv konstruktora és/vagy gettere alighanem hibás: a getKategoriak() művelete nem megfelelő eredményt ad.", "[kat1, kat2]", Arrays.toString(konyv.getKategoriak()));
		Tests.points += points;
	}

	
	
	/*
	 * Ezek a segédfüggvények a teszteléshez használatosak. Ezeket ne kommentezd
	 * ki. Mindegyik valamilyen tulajdonságot ellenőriz és kivételt vált ki, ha
	 * nem teljesül az adott tulajdonság.
	 */

	private static void assertTrue(String msg, boolean p) {
		if (!p) {
			throw new RuntimeException(msg);
		}
	}

	private static void assertEquals(String msg, Object expected, Object actual) {
		if (expected == null && actual == null) {
			return;
		}
		if (expected == null || !expected.equals(actual)) {
			throw new RuntimeException(msg + ", expected: " + expected + ", actual: " + actual);
		}
	}

}

