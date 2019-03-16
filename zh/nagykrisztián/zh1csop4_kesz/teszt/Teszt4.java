package teszt;

import java.util.*;
import szallitas.*;

public class Teszt4 extends Teszt {

    @Override
    public boolean teszt() {

        Doboz d1 = new Doboz(100); //ertek: 100, nem torekeny
        Doboz d2 = new Doboz(200); //ertek: 200, nem torekeny
        TorekenyDoboz d3 = new TorekenyDoboz(300); //ertek: 360, torekeny
        Doboz d4 = new TorekenyDoboz(400); //ertek: 480, torekeny
        Doboz d5 = new TorekenyDoboz(100, true); //ertek: 120, torekeny
        Doboz d6 = new TorekenyDoboz(100, false); //ertek: 100, nem torekeny
        
        //Szallito tesztje
        Szallito sz1 = new Szallito(4, 2); //2 normal, 2 "torekeny" hely
        
        if (sz1.getDobozok1().size() != 0) 
            hiba("Kezdetben a szallitonal nem ures a normal rakodoter.");
        if (sz1.getDobozok2().size() != 0) 
            hiba("Kezdetben a szallitonal nem ures a normal rakodoter.");
        if (! sz1.felrak(d1)) hiba("A d1 doboz felrakasa nem sikerult az sz1 szallitora, pedig felfer.");
        if (! sz1.getDobozok1().contains(d1))
            hiba("A d1 doboz nem kerult a normal helyen levo dobozok koze az sz1 szallitora.");
        if (! sz1.felrak(d6)) hiba("A d6 doboz felrakasa nem sikerult az sz1 szallitora, pedig felfer.");
        if (! sz1.getDobozok1().contains(d6))
            hiba("A d6 doboz nem kerult a normal helyen levo dobozok koze az sz1 szallitora.");
        if (! sz1.felrak(d2)) hiba("A d2 doboz felrakasa nem sikerult az sz1 szallitora, pedig felfer.");
        if (sz1.getDobozok1().contains(d2))
            hiba("A d2 doboznak nem a normal helyen levok kozott kellene lenni, mert oda mar nem fert.");
        if (! sz1.getDobozok2().contains(d2))
            hiba("A d2 doboznak a torekeny helyen levok kozott kellene lennie az sz1 szalliton, mert csak ott volt mar hely.");
        if (! sz1.felrak(d3)) hiba("A d3 doboz felrakasa nem sikerult az sz1 szallitora, pedig felfer.");
        if (! sz1.getDobozok2().contains(d3))
            hiba("A d3 doboznak a torekeny helyen levok kozott kellene lennie az sz1 szalliton.");
        
        //Szallito tesztje - masfele felpakolas
        Szallito sz2 = new Szallito(4, 2); //2 normal, 2 "torekeny" hely
        
        sz2.felrak(d1); 
        if (! sz2.felrak(d3)) hiba("A d3 doboz felrakasa nem sikerult az sz2 szallitora, pedig felfer.");
        if (! sz2.getDobozok2().contains(d3))
            hiba("A d3 doboznak a torekeny helyen levok kozott kellene lennie az sz2 szalliton.");
        if (! sz2.felrak(d4)) hiba("A d4 doboz felrakasa nem sikerult az sz2 szallitora, pedig felfer.");
        if (! sz2.getDobozok2().contains(d4))
            hiba("A d4 doboznak a torekeny helyen levok kozott kellene lennie az sz2 szalliton."); 			
        if (sz2.felrak(d5))
            hiba("A d5 doboz felrakasa sikeresnek van jelezve, pedig mar nem fer fel a torekenyeknek fenntartott helyre.");
        if (sz2.getDobozok1().contains(d5))
            hiba("A d5 doboznak nem kellene az sz2 szalliton lennie a normal dobozok kozott."); 		
        if (sz2.getDobozok2().contains(d5))
            hiba("A d5 doboznak nem kellene az sz2 szalliton lennie a torkenyek kozott sem.");
        sz2.felrak(d2);
        if (sz2.getDobozok1().size() != 2)
            hiba("Az sz2 szalliton most 2 dobozonak kellene lennie a normal rakodoterben.");
        if (sz2.getDobozok2().size() != 2)
            hiba("Az sz2 szalliton most 2 dobozonak kellene lennie a tokenyeknek fenntartott rakodoterben.");
        if (sz2.felrak(d6))
            hiba("A d6 doboz felrakasa sikeresnek van jelezve, mar nem fer fel az sz2 szallitora.");
        if (sz2.getDobozok1().contains(d6))
            hiba("A d6 doboznak nem kellene az sz2 szalliton lennie a normal dobozok kozott."); 		
        if (sz2.getDobozok2().contains(d6))
            hiba("A d6 doboznak nem kellene az sz2 szalliton lennie a torkenyek kozott.");
	
        return ok;
    }
}