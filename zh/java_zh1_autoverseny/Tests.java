import java.util.Arrays;
import java.util.List;

import verseny.Verseny;
import verseny.Versenyzo;

public class Tests {
	private static int points = 0;

	static interface ScorerRunnable {
		public void run() throws Exception;
	}
	
	public static void main(String[] args) throws Exception {
		scoreVersenyzoKonstruktorSokVersenyzovel(2);
		scoreVersenyzoKonstruktorEsGetter(6);
		scoreVersenyzoKonstruktorEnkapszulalt(2);
		scoreJavaVersenyzo(2);
		scoreVersenyzoGetterEnkapszulalt(2);
		scoreVersenyzoSetter(4);
		scoreVersenyzoSetterEnkapszulalt(2);
		scoreVersenyzoKonstruktorEgyetlenSzoveg(2);
		scoreVersenyzoToString(5);
		scoreVersenyzoHasVerseny(4);
		scoreVersenyKonstruktor(6);
		scoreGetVersenyVersenyzoi(4);

		System.out.println("Elert pontszam: " + points);
	}

	private static void scoreJavaVersenyzo(int points) {
		assertEquals("A javaVersenyzo neve nem James Gosling.", "James Gosling", Versenyzo.javaVersenyzo.getNev());
		assertEquals("A javaVersenyzo nem 1 versenyen vett részt.", 1, Versenyzo.javaVersenyzo.getVersenyek().length);
		assertEquals("A javaVersenyzo nem a Kanada Openen vett részt.", "Kanada Open", Versenyzo.javaVersenyzo.getVersenyek()[0]);
		Tests.points += points;
	}

	private static void scoreVersenyzoKonstruktorEgyetlenSzoveg(int points) {
		Versenyzo versenyzo = new Versenyzo("VersenyzoNeve,verseny1,verseny2");

		assertEquals("A Versenyzo vesszős-szöveges konstruktora hibás lehet: a kapott versenyző neve helytelen.", "VersenyzoNeve", versenyzo.getNev());
		assertTrue("A Versenyzo vesszős-szöveges konstruktora hibás lehet: a kapott versenyzőnek nincsen meg egy elvárt versenye", versenyzo.hasVerseny("verseny1"));
		assertTrue("A Versenyzo vesszős-szöveges konstruktora hibás lehet: a kapott versenyzőnek nincsen meg egy elvárt versenye", versenyzo.hasVerseny("verseny2"));
		assertTrue("A Versenyzo vesszős-szöveges konstruktora hibás lehet: a kapott versenyzőnek nem elvárt versenye van", !versenyzo.hasVerseny("verseny3"));
		Tests.points += points;
	}

	private static void scoreGetVersenyVersenyzoi(int points) throws Exception {
		Verseny verseny = new Verseny("verseny1.txt");

		assertTrue("A verseny1.txt versenyének getVersenyVersenyzoi() művelete eredményében benne van a nem várt 'nincs ilyen'.", verseny.getVersenyVersenyzoi("nincs ilyen").isEmpty());
		List<Versenyzo> versenyA = verseny.getVersenyVersenyzoi("versenyA");
		assertEquals("A verseny1.txt versenyének getVersenyVersenyzoi() művelete 'versenyA' paraméterre nem megfelelő hosszú listát ad.", 2, versenyA.size());
		List<Versenyzo> versenyB = verseny.getVersenyVersenyzoi("versenyB");
		assertEquals("A verseny1.txt versenyének getVersenyVersenyzoi() művelete 'versenyB' paraméterre nem megfelelő hosszú listát ad.", 2, versenyB.size());
		List<Versenyzo> versenyC = verseny.getVersenyVersenyzoi("versenyC");
		assertEquals("A verseny1.txt versenyének getVersenyVersenyzoi() művelete 'versenyC' paraméterre nem megfelelő hosszú listát ad.", 2, versenyC.size());
		List<Versenyzo> versenyD = verseny.getVersenyVersenyzoi("versenyD");
		assertEquals("A verseny1.txt versenyének getVersenyVersenyzoi() művelete 'versenyD' paraméterre nem megfelelő hosszú listát ad.", 1, versenyD.size());
		List<Versenyzo> versenyE = verseny.getVersenyVersenyzoi("versenyE");
		assertEquals("A verseny1.txt versenyének getVersenyVersenyzoi() művelete 'versenyE' paraméterre nem megfelelő hosszú listát ad.", 1, versenyE.size());
		List<Versenyzo> versenyF = verseny.getVersenyVersenyzoi("versenyF");
		assertEquals("A verseny1.txt versenyének getVersenyVersenyzoi() művelete 'versenyF' paraméterre nem megfelelő hosszú listát ad.", 1, versenyF.size());

		Versenyzo v1 = versenyD.get(0);
		assertTrue("verseny1.txt: A getVersenyVersenyzoi('versenyA') eredményében nem szerepel az elvárt 'Versenyzo1'.", versenyA.contains(v1));
		assertTrue("verseny1.txt: A getVersenyVersenyzoi('versenyB') eredményében nem szerepel az elvárt 'Versenyzo1'.", versenyB.contains(v1));
		assertTrue("verseny1.txt: A getVersenyVersenyzoi('versenyC') eredményében nem szerepel az elvárt 'Versenyzo1'.", versenyC.contains(v1));
		assertTrue("verseny1.txt: A getVersenyVersenyzoi('versenyD') eredményében nem szerepel az elvárt 'Versenyzo1'.", versenyD.contains(v1));
		assertTrue("verseny1.txt: A getVersenyVersenyzoi('versenyE') eredményében szerepel a nem várt 'Versenyzo1'.", !versenyE.contains(v1));
		assertTrue("verseny1.txt: A getVersenyVersenyzoi('versenyF') eredményében szerepel a nem várt 'Versenyzo1'.", !versenyF.contains(v1));
		
		Tests.points += points;
	}

	private static void scoreVersenyKonstruktor(int points) throws Exception {
		Verseny verseny = new Verseny("verseny1.txt");

		assertEquals("A verseny1.txt fájlból vett Verseny toString-je nem az elvárt eredményt adja.", "Verseny:(Verseny1, Versenyzo[Versenyzo1, [versenyA, versenyB, versenyC, versenyD]], Versenyzo[Versenyzo2, [versenyA, versenyE]], Versenyzo[Versenyzo3, [versenyB, versenyC, versenyF]])", verseny.toString());
		Tests.points += points;
	}

	private static void scoreVersenyzoHasVerseny(int points) {
		Versenyzo versenyzo = new Versenyzo("VersenyzoNeve", new String[] { "verseny1", "verseny2" });

		assertTrue("A Versenyzo hasVerseny() műveletének eredményében nem szerepel egy elvárt érték.", versenyzo.hasVerseny("verseny1"));
		assertTrue("A Versenyzo hasVerseny() műveletének eredményében nem szerepel egy elvárt érték.", versenyzo.hasVerseny("verseny2"));
		assertTrue("A Versenyzo hasVerseny() műveletének eredményében szerepel egy nem várt érték.", !versenyzo.hasVerseny("verseny3"));
		Tests.points += points;
	}

	private static void scoreVersenyzoToString(int points) {
		Versenyzo versenyzo = new Versenyzo("VersenyzoNeve", new String[] { "verseny1", "verseny2" });

		assertEquals("A versenyző toString()-jének eredménye eltér az elvárttól.", "Versenyzo[VersenyzoNeve, [verseny1, verseny2]]", versenyzo.toString());
		Tests.points += points;
	}

	private static void scoreVersenyzoKonstruktorSokVersenyzovel(int points) {
		String[] versenyek = new String[10000];
		for (int i = 0; i < versenyek.length; i++) {
			versenyek[i] = "";
		}

		new Versenyzo("SokVersenyzo", versenyek);
		Tests.points += points;
	}

	private static void scoreVersenyzoSetterEnkapszulalt(int points) {
		Versenyzo versenyzo = new Versenyzo("VersenyzoNeve", new String[] { "verseny1", "verseny2" });
		String[] ujVersenyek = new String[] { "verseny3", "verseny4" };
		versenyzo.setVersenyek(ujVersenyek);

		ujVersenyek[0] = "átírtam";

		assertEquals("A versenyző setVersenyek művelete nem megfelelően enkapszulált (kiszivárog a belső tömb).", "[verseny3, verseny4]", Arrays.toString(versenyzo.getVersenyek()));
		Tests.points += points;
	}

	private static void scoreVersenyzoGetterEnkapszulalt(int points) {
		Versenyzo versenyzo = new Versenyzo("VersenyzoNeve", new String[] { "verseny1", "verseny2" });
		versenyzo.getVersenyek()[0] = "átírtam";

		assertEquals("A versenyző getVersenyek művelete nem megfelelően enkapszulált (kiszivárog a belső tömb).", "[verseny1, verseny2]", Arrays.toString(versenyzo.getVersenyek()));
		Tests.points += points;
	}

	private static void scoreVersenyzoKonstruktorEnkapszulalt(int points) {
		String[] versenyek = new String[] { "verseny1", "verseny2" };
		Versenyzo versenyzo = new Versenyzo("VersenyzoNeve", versenyek);
		versenyek[0] = "átírtam";

		assertEquals("A versenyző konstruktora nem megfelelően enkapszulált (kiszivárog a belső tömb).", "[verseny1, verseny2]", Arrays.toString(versenyzo.getVersenyek()));
		Tests.points += points;
	}

	private static void scoreVersenyzoSetter(int points) {
		Versenyzo versenyzo = new Versenyzo("VersenyzoNeve", new String[] { "verseny1", "verseny2" });

		versenyzo.setNev("UjCim");
		versenyzo.setVersenyek(new String[] { "verseny3", "verseny4" });

		assertEquals("A versenyző settere alighanem hibás: a getNev() művelete nem megfelelő eredményt ad.", versenyzo.getNev(), "UjCim");
		assertEquals("A versenyző settere alighanem hibás: a getVersenyek() művelete nem megfelelő eredményt ad.", Arrays.toString(versenyzo.getVersenyek()), "[verseny3, verseny4]");
		Tests.points += points;
	}

	private static void scoreVersenyzoKonstruktorEsGetter(int points) {
		String[] versenyek = new String[] { "verseny1", "verseny2" };
		Versenyzo versenyzo = new Versenyzo("VersenyzoNeve", versenyek);

		assertEquals("A versenyző konstruktora és/vagy gettere alighanem hibás: a getNev() művelete nem megfelelő eredményt ad.", versenyzo.getNev(), "VersenyzoNeve");
		assertEquals("A versenyző konstruktora és/vagy gettere alighanem hibás: a getVersenyek() művelete nem megfelelő eredményt ad.", "[verseny1, verseny2]", Arrays.toString(versenyzo.getVersenyek()));
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

