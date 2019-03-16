package teszt;

import szallitas.*;
import java.lang.reflect.*;

public class Teszt2 extends Teszt {

    @Override
    public boolean teszt() {
        
        //Doboz tesztje
        Doboz d1 = new Doboz(100);
        Doboz d2 = new Doboz(150);
        
        if (d1.getErtek() != 100) hiba("A Doboz getErtek metodusa hibas");
        d2.setErtek(200);
        if (d2.getErtek() != 200) hiba("A Doboz getErtek v. setErtek metodusa hibas");
        if (d1.torekenyE()) hiba("A Doboz torekenyE metodusa hibas");
        if (d2.torekenyE()) hiba("A Doboz torekenyE metodusa hibas");
        if (! d1.toString().equals("[100]")) hiba("A Doboz(1) toString metodusa hibas");
        if (! d2.toString().equals("[200]")) hiba("A Doboz(2) toString metodusa hibas");
        
        //TorekenyDoboz tesztje
        if (TorekenyDoboz.ertekNovekedes != 20) 
            hiba("A TorekenyDoboz osztaly ertekNovekedes nevu osztályszintu valtozojanak" +
                 "nem megfelelo a kezdoerteke");
        
        TorekenyDoboz td = new TorekenyDoboz(100);		 
        try {
            Class tdClass = td.getClass();
            Field f = tdClass.getDeclaredField("ertekNovekedes");
            if(! Modifier.isFinal(f.getModifiers())) 
                hiba("A TorekenyDoboz osztaly ertekNovekedes nevu osztályszintu valtozojanak" +
                     " meg lehet valtoztatni az erteket");
        } catch (NoSuchFieldException e) {
            hiba("A TorekenyDoboz osztalynak nincs ertekNovekedes nevu valtozoja");
        }		 
	
        TorekenyDoboz d3 = new TorekenyDoboz(300);
        Doboz d4 = new TorekenyDoboz(400);
        if (d3.getErtek() != 360) hiba("A TorekenyDoboz getErtek metodusa hibas eredmenyt ad");
        if (d4.getErtek() != 480) hiba("A TorekenyDoboz getErtek metodusa hibas eredmenyt ad");
        if (! d3.torekenyE()) hiba("A TorekenyDoboz torekenyE metodusa hibas");
        if (! d4.torekenyE()) hiba("A TorekenyDoboz torekenyE metodusa hibas");
        if (! d3.toString().equals("[!360]")) hiba("A TorekenyDoboz toString metodusa hibas");
        if (! d4.toString().equals("[!480]")) hiba("Az TorekenyDoboz toString metodusa hibas");
        
        //Gyar tesztje
        Gyar gy = new Gyar();
        gy.legyart(d1); gy.legyart(d2); gy.legyart(d3); gy.legyart(d4);
        if (gy.dobozokSzama() != 4) 
            hiba("Nem megfelelo szamu doboz van a futoszalagon 4 doboz legyartasa utan a Gyarban.");
        
        return ok;
    }
}