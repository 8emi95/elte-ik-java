package teszt;

import java.util.*;
import szallitas.*;

public class Teszt3 extends Teszt {

    @Override
    public boolean teszt() {

        Doboz d1 = new Doboz(100);
        Doboz d2 = new Doboz(200);
        TorekenyDoboz d3 = new TorekenyDoboz(300);
        Doboz d4 = new TorekenyDoboz(400);
        
        Gyar gy = new Gyar();
        
        //Gyar tesztje
        if (gy.getElsoNormalDoboz() != null) 
            hiba("A Gyar getElsoNormalDoboz metodusa ures futoszalagra nem mukodik jol.");
        
        gy.legyart(d3); 
        
        if (gy.getElsoNormalDoboz() != null) 
            hiba("A Gyar getElsoNormalDoboz metodusa nem mukodik jol, ha csak torekeny doboz van a szalagon.");
        if (! gy.toString().equals("[!360]")) 
            hiba("A Gyar toString metodusa hibas egy elemre.");
        
        gy.legyart(d1); gy.legyart(d2); gy.legyart(d4);
        
        if (! gy.toString().equals("[!360]_[100]_[200]_[!480]")) 
            hiba("A Gyar toString metodusa hibas 4 elemre.");
  
        if (gy.getElsoNormalDoboz() != d1) 
            hiba("A Gyar getElsoNormalDoboz metodusa nem az elso normal dobozt adja viszza");
        if (gy.getElsoNormalDoboz() != d1) 
            hiba("A Gyar getElsoNormalDoboz metodusa nem az elso normal dobozt adja viszza a masodik lekerdezes alkalmaval");
        
        
        //TorekenyDoboz tesztje
        Doboz d5 = new TorekenyDoboz(100, true);
        Doboz d6 = new TorekenyDoboz(100, false);
        if (d5.getErtek() != 120) hiba("A TorekenyDoboz getErtek metodusa hibas eredmenyt ad d5-nel");
        if (d6.getErtek() != 100) hiba("A TorekenyDoboz getErtek metodusa hibas eredmenyt ad d6-nal");
        if (! d5.torekenyE()) hiba("A TorekenyDoboz torekenyE metodusa hibas eredmenyt ad d5-nel");
        if (d6.torekenyE()) hiba("A TorekenyDoboz torekenyE metodusa hibas eredmenyt ad d6-nal");
        if (! d5.toString().equals("[!120]")) hiba("A TorekenyDoboz toString metodusa hibas eredmenyt ad d5-nel");
        if (! d6.toString().equals("[100]")) hiba("Az TorekenyDoboz toString metodusa hibas redmenyt ad d6-nal");
        
        return ok;
    }
}