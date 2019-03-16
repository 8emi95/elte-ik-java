package teszt;

import java.util.*;
import szallitas.*;

public class Teszt5 extends Teszt {

    @Override
    public boolean teszt() {
        
        Doboz d1 = new Doboz(100); //ertek: 100, nem torekeny
        Doboz d2 = new Doboz(200); //ertek: 200, nem torekeny
        TorekenyDoboz d3 = new TorekenyDoboz(300); //ertek: 360, torekeny
        Doboz d4 = new TorekenyDoboz(400); //ertek: 480, torekeny
        Doboz d5 = new TorekenyDoboz(100, true); //ertek: 120, torekeny
        Doboz d6 = new TorekenyDoboz(100, false); //ertek: 100, nem torekeny
        
        Szallito sz = new Szallito(4, 2); //2 normal, 2 "torekeny" hely
        
        Gyar gy = new Gyar();
        gy.legyart(d6); gy.legyart(d5);  gy.legyart(d4);
        gy.legyart(d3); gy.legyart(d2);  gy.legyart(d1);
        
        //(1)-es blokk: elszallitas tesztje
        int db = gy.elszallit(sz); 
            // a d6 es d2 kerulnek a normal helyekre, a d5 es d4 a torekenyeknek fenntartottakra
            // a szalagon maradt: d3, d1
        
        if (db != 4)
            hiba("(1) Nem megfelelo szamu doboz kerult elszallitasra"+
                 " az elszallit metodus visszateresi erteke alapjan");
        if (gy.dobozokSzama() != 2)
            hiba("(1) Nem megfelelo szamu doboz maradt a szalagon az elszallitas utan");
        if (sz.getDobozok1().size() + sz.getDobozok2().size() != 4)
            hiba("(1) A szallitora 4 doboznak kellett volna felkerulnie");
        if (! sz.getDobozok1().contains(d6))
            hiba("(1) A szallitora nem (v. nem a megfelelo helyre) kerult fel a d6 doboz");
        if (! sz.getDobozok1().contains(d2))
            hiba("(1) A szallitora nem (v. nem a megfelelo helyre) kerult fel a d2 doboz");
        if (! sz.getDobozok2().contains(d5))
            hiba("(1) A szallitora nem (v. nem a megfelelo helyre) kerult fel a d5 doboz");
        if (! sz.getDobozok2().contains(d4))
            hiba("(1) A szallitora nem (v. nem a megfelelo helyre) kerult fel a d4 doboz");
        
        //(2)-es blokk: lepakol 1-et
        int osszertek = sz.lepakol(1);
            //a d5 doboznak kellene lekerulnie
            //fent van igy a normal helyen d6,d2; a torekenyen: d4
        if (osszertek != 120)
            hiba("(2) A lepakol metodus altal visszaadott eredmeny hibas");
        if (sz.getDobozok1().size() + sz.getDobozok2().size() != 3)
            hiba("(2) A szalliton 3 doboznak kellett volna maradnia");
        if (! sz.getDobozok1().contains(d6))
            hiba("(2) A szallitorol lekerulhetett a d6 doboz.");
        if (! sz.getDobozok1().contains(d2))
            hiba("(2) A szallitorol lekerulhetett a d2 doboz");
        if (sz.getDobozok2().contains(d5))
            hiba("(2) A szallitorol nem kerult le a d5 doboz");
        if (! sz.getDobozok2().contains(d4))
            hiba("(2) A szallitorol lekerulhetett a d4 doboz");	

        //(3)-as blokk: lepakolas utani felpakolas
        db = gy.elszallit(sz); 
            //a d3 doboznak kellett felkerulnie a szallitora (fent van igy a normal helyen d6,d2; a torekenyen: d4,d3)
            //a gyarban maradt: d1     
           
        if (db != 1)
            hiba("(3) Nem megfelelo szamu doboz kerult elszallitasra"+
                 " az elszallit metodus visszateresi erteke alapjan");
        if (gy.dobozokSzama() != 1)
            hiba("(3) Nem megfelelo szamu doboz maradt a szalagon az elszallitas utan");
        if (sz.getDobozok1().size() + sz.getDobozok2().size() != 4)
            hiba("(3) A szalliton most osszesen 4 doboznak kell lennie");
        if (! sz.getDobozok2().contains(d3))
            hiba("(3) A szallitora nem kerult fel a d3 doboz");

        //(4)-es blokk: ujabb lepakolas
        osszertek = sz.lepakol(3); 
            //a d4, d3, d6 dobozoknak kell lekerulnie, marad: d2
        if (osszertek != (480 + 360 + 100))
            hiba("(4) A lepakol metodus altal visszaadott eredmeny hibas");
        if (sz.getDobozok1().size() + sz.getDobozok2().size() != 1)
            hiba("(4) A szalliton 1 doboznak kellett volna maradnia");
        if (sz.getDobozok1().contains(d6))
            hiba("(4) A szallitorol nem kerult le a d6 doboz.");
        if (! sz.getDobozok1().contains(d2))
            hiba("(4) A szallitorol hibasan lekerulhetett a d2 doboz");
        if (sz.getDobozok2().contains(d3))
            hiba("(4) A szallitorol nem kerult le a d3 doboz");
        if (sz.getDobozok2().contains(d4))
            hiba("(4) A szallitorol nem kerult le a d4 doboz");	
        
		//(5)-ös blokk: utolso lepakolas
        osszertek = sz.lepakol(10); 
            //a d2 doboznak kell lekerulnie
        if (osszertek != 200)
            hiba("(5) A lepakol metodus altal visszaadott eredmeny hibas");
        if (sz.getDobozok1().size() + sz.getDobozok2().size() != 0)
            hiba("(5) A szalliton 0 doboznak kellett volna maradnia");
        return ok;
    }
}