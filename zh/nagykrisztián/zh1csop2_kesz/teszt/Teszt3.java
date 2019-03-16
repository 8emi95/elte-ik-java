package teszt;

import java.util.*;
import szallitas.*;

public class Teszt3 extends Teszt {

    @Override
    public boolean teszt() {

        Doboz d1 = new Doboz((byte) 1);
        Doboz d2 = new Doboz((byte) 2);
        SpecialisDoboz d3 = new SpecialisDoboz((byte) 3, (float) 1.2);
        Doboz d4 = new SpecialisDoboz((byte) 4, (float) 0.6);

        Gyar gy = new Gyar();
       
        //Gyar tesztje
        if (gy.getMeretAlattiDoboz(51) != null) 
            hiba("A Gyar getMeretAlattiDoboz metodusa ures futoszalagra nem mukodik jol.");

        gy.legyart(d1); 
       
        if (! gy.toString().equals("[1:50cm]")) 
            hiba("A Gyar toString metodusa hibas.");

        gy.legyart(d2); gy.legyart(d3); gy.legyart(d4);
        
        if (! gy.toString().equals("[1:50cm]_[2:50cm]_[3:60cm]_[4:30cm]")) 
            hiba("A Gyar toString metodusa hibas.");
  
        if (gy.getMeretAlattiDoboz(51) != d1) 
            hiba("A Gyar getMeretAlattiDoboz metodusa nem az elso dobozt adja viszza," + 
                 "pedig belefer a merethatarba.");
        if (gy.getMeretAlattiDoboz(61) != d1) 
            hiba("A Gyar getMeretAlattiDoboz metodusa nem az elso dobozt adja viszza," +
                 "pedig belefer a merethatarba.");
        if (gy.getMeretAlattiDoboz(41) != d4) 
            hiba("A Gyar getMeretAlattiDoboz metodusa nem a 4. dobozt adja viszza," +
                 "pedig csak az fer bele a merethatarba.");
        if (gy.getMeretAlattiDoboz(25) != null) 
            hiba("A Gyar getMeretAlattiDoboz metodusa nem null-t ad vissza,"+
                 "amikor egy doboz sincs, ami belefer a merethatarba");


        //SpecialisDoboz tesztje
        
        Doboz d5 = new SpecialisDoboz((byte) 5); //a szorzo 1
        if (d5.getTermekAzonosito() != 5) 
            hiba("A SpecialisDoboz getTermekAzonosito metodusa hibas");
        if (d5.getMelyseg() != 50) hiba("A SpecialisDoboz getMelyseg metodusa hibas eredmenyt ad");
        if (! d5.toString().equals("[5:50cm]")) hiba("Az SpecialisDoboz toString metodusa hibas");
        
        return ok;
    }
}