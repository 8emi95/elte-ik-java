import raktar.Termek;
import raktar.Szett;
import raktar.Raktar;

public class Tests {
    private static int points = 0;

    public static void main(String[] args) throws Exception {

        //raktar.Termek osztaly tesztelese
        scoreTermekCreateTermekAndGetters(7);
        scoreTermekKedvezmenyAd(2);
        scoreTermekToString(2);

        //rakar.Szett osztaly tesztelese
        scoreSzettCreateSzettAndGetters(6);
        scoreSzettArKiszamol(1);
        scoreSzettToString(1);

        //raktar.Raktar osztaly tesztelese
        scoreRaktarConstructorAndGetCount(2);
        scoreRaktarTermekBeolvasAndTermekGetter(5);
        scoreRaktarSzettBeolvasAndSzettGetter(5);
        scoreRaktarTermekKeres(2);
        scoreRaktarToString(2);

		System.out.println("Elert pontszam: " + points);
	}

    private static void scoreTermekCreateTermekAndGetters(int points) {

        //createTermek fuggveny tesztelese hibas szoveg eseten (ekkor null-t kell visszaadnia)
        Termek termek1 = Termek.createTermek("");
        Termek termek2 = Termek.createTermek("alma");
        Termek termek3 = Termek.createTermek("1,ropi");
        Termek termek4 = Termek.createTermek("1,ropi,100,alma");
        Termek termek5 = Termek.createTermek("1,,100");
        Termek termek6 = Termek.createTermek("alma,korte,barack");
        Termek termek7 = Termek.createTermek("1,alma,korte");
        Termek termek8 = Termek.createTermek("1,ropi,0");

        assertTrue("A Termek osztaly createTermek metodusa hibas input eseten (\"\") is letrehozza az objektumot.", null == termek1);
        assertTrue("A Termek osztaly createTermek metodusa hibas input eseten (\"alma\") is letrehozza az objektumot.", null == termek2);
        assertTrue("A Termek osztaly createTermek metodusa hibas input eseten (\"1,ropi\") is letrehozza az objektumot.", null == termek3);
        assertTrue("A Termek osztaly createTermek metodusa hibas input eseten (\"1,ropi,100,alma\") is letrehozza az objektumot.", null == termek4);
        assertTrue("A Termek osztaly createTermek metodusa hibas input eseten (\"1,,100\") is letrehozza az objektumot.", null == termek5);
        assertTrue("A Termek osztaly createTermek metodusa hibas input eseten (\"alma,korte,barack\") is letrehozza az objektumot.", null == termek6);
        assertTrue("A Termek osztaly createTermek metodusa hibas input eseten (\"1,alma,korte\") is letrehozza az objektumot.", null == termek7);
        assertTrue("A Termek osztaly createTermek metodusa hibas input eseten (\"1,ropi,0\") is letrehozza az objektumot.", null == termek8);

        Tests.points += 3;

        //createTermek fuggveny tesztelese helyes szoveg eseten (ekkor nem null-t kell visszaadnia)
        Termek termek9 = Termek.createTermek("1,alma,200");
        Termek termek10 = Termek.createTermek("2,ropi,100");
        Termek termek11 = Termek.createTermek("3,csoki,80");

        assertTrue("A Termek osztaly createTermek metodusa helyes input eseten (\"1,alma,200\") sem hozza letre az objektumot.", null != termek9);
        assertTrue("A Termek osztaly createTermek metodusa helyes input eseten (\"2,ropi,100\") sem hozza letre az objektumot.", null != termek10);
        assertTrue("A Termek osztaly createTermek metodusa helyes input eseten (\"3,csoki,80\") sem hozza letre az objektumot.", null != termek11);
        
        Tests.points += 1;

        //createTermek fuggveny tesztelese: helyes szoveg eseten helyes objektumot hoz-e letre
        assertEquals("A Termek osztaly createTermek metodusa helytelen adatokat tarol.", 1, termek9.getAzonosito());
        assertEquals("A Termek osztaly createTermek metodusa helytelen adatokat tarol.", "ropi", termek10.getNev());
        assertEquals("A Termek osztaly createTermek metodusa helytelen adatokat tarol.", 80, termek11.getAr());

        Tests.points += 3;

	}

    private static void scoreTermekKedvezmenyAd(int points) {

        Termek termek1 = Termek.createTermek("1,alma,200");
        
        termek1.kedvezmenyAd(10);
        assertEquals("A Termek osztaly kedvezmenyAd metodusa helytelenul szamol.", 180, termek1.getAr());
        
        termek1.kedvezmenyAd(20);
        assertEquals("A Termek osztaly kedvezmenyAd metodusa helytelenul szamol.", 144, termek1.getAr());
        
        Termek termek2 = Termek.createTermek("2,ropi,100");
        Termek termek3 = Termek.createTermek("3,csoki,80");

        termek2.kedvezmenyAd(110);
        assertEquals("A Termek osztaly kedvezmenyAd metodusa helytelen parameterre is valtoztatja az arat.", 100, termek2.getAr());
        
        termek3.kedvezmenyAd(-20);
        assertEquals("A Termek osztaly kedvezmenyAd metodusa helytelen parameterre is valtoztatja az arat.", 80, termek3.getAr());
        
        Tests.points += points;

    }

    private static void scoreTermekToString(int points) {

        Termek termek1 = Termek.createTermek("1,alma,200");
        Termek termek2 = Termek.createTermek("2,ropi,100");
        Termek termek3 = Termek.createTermek("3,csoki,80");
        
        assertEquals("A Termek osztaly toString metodusa helytelen eredmenyt ad.", "1: alma (200 Ft)", termek1.toString());
        assertEquals("A Termek osztaly toString metodusa helytelen eredmenyt ad.", "2: ropi (100 Ft)", termek2.toString());
        assertEquals("A Termek osztaly toString metodusa helytelen eredmenyt ad.", "3: csoki (80 Ft)", termek3.toString());
        
        Tests.points += points;

    }

    private static void scoreSzettCreateSzettAndGetters(int points) {

        //createSzett fuggveny tesztelese hibas szoveg eseten (ekkor null-t kell visszaadnia)
        Szett szett1 = Szett.createSzett("");
        Szett szett2 = Szett.createSzett("alma");
        Szett szett3 = Szett.createSzett("1,ropi");
        Szett szett4 = Szett.createSzett("1,ropi,100,alma,10,10");
        Szett szett5 = Szett.createSzett("1,,100,20,30");
        Szett szett6 = Szett.createSzett("alma,korte,barack,joska,pista");
        Szett szett7 = Szett.createSzett("1,alma,korte,20,30");
        Szett szett8 = Szett.createSzett("1,ropi,3,0,20");
        Szett szett9 = Szett.createSzett("1,ropi,3,10,110");

        assertTrue("A Szett osztaly createSzett metodusa hibas input eseten (\"\") is letrehozza az objektumot.", null == szett1);
        assertTrue("A Szett osztaly createSzett metodusa hibas input eseten (\"alma\") is letrehozza az objektumot.", null == szett2);
        assertTrue("A Szett osztaly createSzett metodusa hibas input eseten (\"1,ropi\") is letrehozza az objektumot.", null == szett3);
        assertTrue("A Szett osztaly createSzett metodusa hibas input eseten (\"1,ropi,100,alma,10,10\") is letrehozza az objektumot.", null == szett4);
        assertTrue("A Szett osztaly createSzett metodusa hibas input eseten (\"1,,100,20,30\") is letrehozza az objektumot.", null == szett5);
        assertTrue("A Szett osztaly createSzett metodusa hibas input eseten (\"alma,korte,barack,joska,pista\") is letrehozza az objektumot.", null == szett6);
        assertTrue("A Szett osztaly createSzett metodusa hibas input eseten (\"1,alma,korte,20,30\") is letrehozza az objektumot.", null == szett7);
        assertTrue("A Szett osztaly createSzett metodusa hibas input eseten (\"1,ropi,3,0,20\") is letrehozza az objektumot.", null == szett8);
        assertTrue("A Szett osztaly createSzett metodusa hibas input eseten (\"1,ropi,3,10,110\") is letrehozza az objektumot.", null == szett9);

        Tests.points += 3;

        //createSzett fuggveny tesztelese helyes szoveg eseten (ekkor nem null-t kell visszaadnia)
        Szett szett10 = Szett.createSzett("1,alma-csomag,4,20,5");
        Szett szett11 = Szett.createSzett("2,ropi-csomag,5,100,20");
        Szett szett12 = Szett.createSzett("3,csoki-csomag,6,10,2");

        assertTrue("A Szett osztaly createSzett metodusa helyes input eseten (\"1,alma-csomag,4,20,5\") sem hozza letre az objektumot.", null != szett10);
        assertTrue("A Szett osztaly createSzett metodusa helyes input eseten (\"2,ropi-csomag,5,100,20\") sem hozza letre az objektumot.", null != szett11);
        assertTrue("A Szett osztaly createSzett metodusa helyes input eseten (\"3,csoki-csomag,6,10,2\") sem hozza letre az objektumot.", null != szett12);

        Tests.points += 1;

        //createSzett fuggveny tesztelese: helyes szoveg eseten helyes objektumot hoz-e letre
        assertEquals("A Szett osztaly createSzett metodusa helytelen adatokat tarol.", 1, szett10.getAzonosito());
        assertEquals("A Szett osztaly createSzett metodusa helytelen adatokat tarol.", "ropi-csomag", szett11.getNev());
        assertEquals("A Szett osztaly createSzett metodusa helytelen adatokat tarol.", -1, szett12.getAr());
        assertEquals("A Szett osztaly createSzett metodusa helytelen adatokat tarol.", 6, szett12.getAlapTermekAzonosito());

        Tests.points += 2;

	}

    private static void scoreSzettArKiszamol(int points) {

        Szett szett = Szett.createSzett("1,ropi-csomag,5,10,20");
        
        szett.arKiszamol(60);
        assertEquals("A Szett osztaly arKiszamol metodusa helytelenul szamol.", 480, szett.getAr());
        
        szett.arKiszamol(-20);
        assertEquals("A Szett osztaly arKiszamol metodusa helytelen parameterre is valtoztatja az arat.", 480, szett.getAr());
       
        Tests.points += points;

    }

    private static void scoreSzettToString(int points) {

        Szett szett1 = Szett.createSzett("1,alma-csomag,4,20,5");   szett1.arKiszamol(60);
        Szett szett2 = Szett.createSzett("2,ropi-csomag,5,100,20"); szett2.arKiszamol(100);
        
        assertEquals("A Szett osztaly toString metodusa helytelen eredmenyt ad.", "1: alma-csomag (1140 Ft)", szett1.toString());
        assertEquals("A Szett osztaly toString metodusa helytelen eredmenyt ad.", "2: ropi-csomag (8000 Ft)", szett2.toString());
        
        Tests.points += points;

    }

    private static void scoreRaktarConstructorAndGetCount(int points) {

        Raktar raktar = new Raktar();
        
        assertEquals("A Raktar osztaly konstruktora, vagy termekekSzama nevu metodusa helytelenul mukodik.", 0, raktar.termekekSzama());
        assertEquals("A Raktar osztaly konstruktora, vagy szettekSzama nevu metodusa helytelenul mukodik.", 0, raktar.szettekSzama());
        
        Tests.points += points;

    }

    private static void scoreRaktarTermekBeolvasAndTermekGetter(int points) throws Exception {

        Raktar raktar = new Raktar();
        raktar.termekBeolvas("termekInput.txt");
        
        assertEquals("A Raktar osztaly termekBeolvas metodusa nem megfelelo mennyisegu termeket rogzit.", 4, raktar.termekekSzama());

        assertEquals("A Raktar osztaly termekBeolvas metodusa nem rogziti megfeleoen a termekeket (vagy a getTermek metodus ad vissza rosszat).", "1: alma (200 Ft)", raktar.getTermek(0).toString());
        assertEquals("A Raktar osztaly termekBeolvas metodusa nem rogziti megfeleoen a termekeket (vagy a getTermek metodus ad vissza rosszat).", "2: ropi (100 Ft)", raktar.getTermek(1).toString());
        assertEquals("A Raktar osztaly termekBeolvas metodusa nem rogziti megfeleoen a termekeket (vagy a getTermek metodus ad vissza rosszat).", "3: csoki (80 Ft)", raktar.getTermek(2).toString());
        assertEquals("A Raktar osztaly termekBeolvas metodusa nem rogziti megfeleoen a termekeket (vagy a getTermek metodus ad vissza rosszat).", "4: cukor (150 Ft)", raktar.getTermek(3).toString());
        
        assertEquals("A Raktar osztaly getTermek metodusa rossz indexre is visszaad termeket.", null, raktar.getTermek(4));
        assertEquals("A Raktar osztaly getTermek metodusa rossz indexre is visszaad termeket.", null, raktar.getTermek(-1));
        
        Tests.points += points;

    }

    private static void scoreRaktarSzettBeolvasAndSzettGetter(int points) throws Exception {

        Raktar raktar = new Raktar();
        raktar.termekBeolvas("termekInput.txt");
        raktar.szettBeolvas("szettInput.txt");
        
        assertEquals("A Raktar osztaly szettBeolvas metodusa nem megfelelo mennyisegu termeket rogzit.", 3, raktar.szettekSzama());
        
        assertEquals("A Raktar osztaly szettBeolvas metodusa nem rogziti megfeleoen a szetteket (vagy a getSzett metodus ad vissza rosszat).", "5: alma-csomag (950 Ft)", raktar.getSzett(0).toString());
        assertEquals("A Raktar osztaly szettBeolvas metodusa nem rogziti megfeleoen a szetteket (vagy a getSzett metodus ad vissza rosszat).", "6: ropi-csomag (850 Ft)", raktar.getSzett(1).toString());
        assertEquals("A Raktar osztaly szettBeolvas metodusa nem rogziti megfeleoen a szetteket (vagy a getSzett metodus ad vissza rosszat).", "7: csoki-csomag (1120 Ft)", raktar.getSzett(2).toString());
        
        assertEquals("A Raktar osztaly getSzett metodusa rossz indexre is visszaad szettet.", null, raktar.getSzett(3));
        assertEquals("A Raktar osztaly getSzett metodusa rossz indexre is visszaad szettet.", null, raktar.getSzett(-1));
        
        Tests.points += points;

    }

    private static void scoreRaktarTermekKeres(int points) throws Exception {

        Raktar raktar = new Raktar();
        raktar.termekBeolvas("termekInput.txt");
        
        assertEquals("A Raktar osztaly termekBeolvas vagy termekKeres metodusa nem mukodik megfeleloen.", "3: csoki (80 Ft)", raktar.termekKeres(3).toString());
        assertEquals("A Raktar osztaly termekBeolvas vagy termekKeres metodusa nem mukodik megfeleloen.", null, raktar.termekKeres(5));
        
        Tests.points += points;

    }

    private static void scoreRaktarToString(int points) throws Exception {

        Raktar raktar = new Raktar();
        raktar.termekBeolvas("termekInput.txt");
        raktar.szettBeolvas("szettInput.txt");
        
        assertEquals("A Raktar osztaly toString metodusa nem megfelelo eredmenyt (vagy az termekBeolvas vagy a szettBeolvas rogzit rossz erteket).",
            "1: alma (200 Ft)\n2: ropi (100 Ft)\n3: csoki (80 Ft)\n4: cukor (150 Ft)\n5: alma-csomag (950 Ft)\n6: ropi-csomag (850 Ft)\n7: csoki-csomag (1120 Ft)\n",
            raktar.toString());
        
        Tests.points += points;

    }

    /*
     * Ezek a segedfuggvenyek a teszteleshez hasznalatosak. Ezeket ne kommentezd
     * ki. Mindegyik valamilyen tulajdonságot ellenoriz es kivetelt valt ki, ha
     * nem teljesul az adott tulajdonsag.
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
