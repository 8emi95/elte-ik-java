package test;

import java.util.*;
import szallitas.*;

public class Test5 extends Test {

    @Override
    public boolean test() {
        
        Doboz d1 = new Doboz(100);
        Doboz d2 = new Doboz(200);
        IranyitottDoboz d3 = new IranyitottDoboz(300,(byte) 3);
        IranyitottDoboz d4 = new IranyitottDoboz(400, (byte) 4);
        IranyitottDoboz d5 = new IranyitottDoboz(500);
       
        Gyar gy = new Gyar();
        gy.legyart(d1);  gy.legyart(d2);  gy.legyart(d3);  gy.legyart(d4);  gy.legyart(d5);
        
        Szallito sz = new Szallito();
        sz.addUticel((byte) 3);

        //Gyar tesztje
        if (gy.elszallit(sz) != 4)
            hiba("Nem megfelelo szamu dobozt pakoltunk fel a szallitonak");

        if (gy.dobozokSzama() != 1)
            hiba("Nem megfelelo szamu doboz maradt a szalagon.");

        if (! (sz.getDobozok().contains(d1) && sz.getDobozok().contains(d2) 
               && sz.getDobozok().contains(d3) && sz.getDobozok().contains(d5)))
            hiba("A szallitora nem a megfelelo dobozokat pakoltuk fel");
        if (sz.getDobozok().contains(d4))
            hiba("A szalliton egy olyan doboz is van, aminek nem kellene");
        
        //Szallito tesztje
        if (sz.lepakol((byte) 1) != 800)
            hiba("A kozponti raktarban lepakolt dobozok osszerteke nem stimmel");
        if (sz.getDobozok().size() != 1)
            hiba("Az elso lepakolas utan 1 doboznak kellene a szalliton maradni");
        if (sz.lepakol((byte) 3) != 360)
            hiba("A 3-as raktarban lepakolt dobozok osszerteke nem stimmel");
        if (sz.getDobozok().size() != 0)
            hiba("Az elso lepakolas utan 0 doboznak kellene a szalliton maradni");

        return ok;
      
    }
}