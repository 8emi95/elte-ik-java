package teszt;

import java.util.*;
import szallitas.*;

public class Teszt5 extends Teszt {

    @Override
    public boolean teszt() {
        
        Doboz d1 = new Doboz((byte) 1); //50
        Doboz d2 = new Doboz((byte) 4); //50
        SpecialisDoboz d3 = new SpecialisDoboz((byte) 3, (float) 1.2); //60
        Doboz d4 = new SpecialisDoboz((byte) 4, (float) 0.6); //30
        Doboz d5 = new SpecialisDoboz((byte) 5); //50
        Doboz d6 = new SpecialisDoboz((byte) 6, (float) 0.5); //25

        Gyar gy = new Gyar();
        gy.legyart(d1); gy.legyart(d2);  gy.legyart(d3);
        gy.legyart(d4); gy.legyart(d5);  gy.legyart(d6);

        Szallito sz = new Szallito(156);
        
        //elszallitas tesztje
        int db = gy.elszallit(sz); 
            //a d1, d2, d4 és d5 dobozoknak kell felkerulnie a szallitora
            //1 cm szabad hely maradt
            //a gyarban maradt: d3, d6     
           
        if (db != 4)
            hiba("Nem megfelelo szamu doboz kerult elszallitasra"+
                 "az elszallit metodus visszateresi erteke alapjan");
        if (gy.dobozokSzama() != 2)
            hiba("Nem megfelelo szamu doboz maradt a szalagon az elszallitas utan");
        if (sz.getDobozok().size() != 4)
            hiba("A szallitora 4 doboznak kellett volna felkerulnie");
        if (! sz.getDobozok().contains(d1))
            hiba("A szallitora nem kerult fel a d1 doboz");
        if (! sz.getDobozok().contains(d2))
            hiba("A szallitora nem kerult fel a d2 doboz");
        if (! sz.getDobozok().contains(d4))
            hiba("A szallitora nem kerult fel a d4 doboz");
        if (! sz.getDobozok().contains(d6))
            hiba("A szallitora nem kerult fel a d6 doboz");

        //lepakol
        int osszterulet = sz.lepakol((byte) 4); 
            //a d2 es d4 dobozoknak kell lekerulnie
            //81 cm szabad hely maradt
        if (osszterulet != (50+30)*50)
            hiba("A lepakol metodus altal visszaadott eredmeny hibas");
        if (sz.getDobozok().size() != 2)
            hiba("A szalliton 2 doboznak kellett volna maradnia");
        if (! sz.getDobozok().contains(d1))
            hiba("A szallitorol lekerult a d1 doboz");
        if (sz.getDobozok().contains(d2))
            hiba("A szallitorol nem kerult le a d2 doboz");
        if (sz.getDobozok().contains(d4))
            hiba("A szallitorol nem kerult le a d4 doboz");
        if (! sz.getDobozok().contains(d6))
            hiba("A szallitorol lekerulhetett a d6 doboz");

        //lepakolas utani felpakolas
        db = gy.elszallit(sz); 
            //a d3 doboznak kellett felkerulnie a szallitora (fent van igy: d1, d5 es d3)
            //21 cm szabad hely maradt
            //a gyarban maradt: d6     
           
        if (db != 1)
            hiba("Nem megfelelo szamu doboz kerult elszallitasra"+
                 " az elszallit metodus visszateresi erteke alapjan");
        if (gy.dobozokSzama() != 1)
            hiba("Nem megfelelo szamu doboz maradt a szalagon az elszallitas utan");
        if (sz.getDobozok().size() != 3)
            hiba("A szalliton most osszesen 3 doboznak kell lennie");
        if (! sz.getDobozok().contains(d3))
            hiba("A szallitora nem kerult fel a d3 doboz");

        if (!sz.felrak(new SpecialisDoboz((byte) 2, (float) 0.1)))
            hiba("A szallitora nem fert fel egy olyan doboz, aminek fel kellett volna");
        //maradt (21-5)=16 cm hely
        if (sz.felrak(new SpecialisDoboz((byte) 2, (float) 0.5)))
            hiba("A szallitorafelfert egy olyan doboz, aminek nem kellett volna");
        
        /////////////////////////////////////////////////////////
        //masik teszt: 8 normal doboz legyartasa, alapertelmezett meretu szallitoval valo elszallitas
        Gyar gy2 = new Gyar();
        for (int i=0; i<8; i++) {
            gy2.legyart(new Doboz((byte) 1));
        }
        Szallito sz2 = new Szallito();
        db = gy2.elszallit(sz2);
        if (db != 8)
            hiba("Nem 8 doboz kerult elszallitasra"+
                 " az elszallit metodus visszateresi erteke alapjan");
        if (gy2.dobozokSzama() != 0)
            hiba("Nem 0 doboz maradt a szalagon az elszallitas utan");
        osszterulet = sz2.lepakol((byte) 1);
        if (osszterulet != (50*8)*50)
            hiba("A lepakol metodus altal visszaadott eredmeny hibas");
        if (sz2.getDobozok().size() != 0)
            hiba("A szalliton 0 doboznak kellett volna maradnia");
        
        return ok;
    }
}