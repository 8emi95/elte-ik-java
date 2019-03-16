package teszt;

import szallitas.*;
import java.lang.reflect.*;

public class Teszt2 extends Teszt {

    @Override
    public boolean teszt() {
        
        //Doboz tesztje
        if (Doboz.szelesseg != 50) 
            hiba("A Doboz osztaly szelesseg nevu osztályszintu valtozojanak" +
                 "nem megfelelo a kezdoerteke");
       
        Doboz d1 = new Doboz((byte) 1);
        Doboz d2 = new Doboz((byte) 3);

        try {
            Class dobozClass = d1.getClass();
            Field szelessegField = dobozClass.getDeclaredField("szelesseg");
            if(! Modifier.isFinal(szelessegField.getModifiers())) 
                hiba("A Doboz osztaly szelesseg nevu osztályszintu valtozojanak" +
                     "meg lehet valtoztatni az erteket");
        } catch (NoSuchFieldException e) {
            hiba("A Doboz osztalynak nincs szelesseg nevu valtozoja");
        }
        
        if (d1.getTermekAzonosito() != 1) 
            hiba("A Doboz getTermekAzonosito metodusa hibas");
        d2.setTermekAzonosito((byte) 2);
        if (d2.getTermekAzonosito() != 2) 
            hiba("A Doboz getTermekAzonosito v. setTermekAzonosito metodusa hibas");
        if (d1.getMelyseg() != 50) hiba("A Doboz getMelyseg metodusa hibas eredmenyt ad");
        if (d2.getMelyseg() != 50) hiba("A Doboz getMelyseg metodusa hibas eredmenyt ad");
        if (! d1.toString().equals("[1:50cm]")) hiba("A Doboz(1) toString metodusa hibas");
        if (! d2.toString().equals("[2:50cm]")) hiba("A Doboz(2) toString metodusa hibas");

        //SpecialisDoboz tesztje
        SpecialisDoboz d3 = new SpecialisDoboz((byte) 3, (float) 1.2);
        Doboz d4 = new SpecialisDoboz((byte) 4, (float) 0.6);
        if (d3.getTermekAzonosito() != 3) 
             hiba("A SpecialisDoboz getTermekAzonosito metodusa hibas");
        if (d4.getTermekAzonosito() != 4) 
            hiba("A SpecialisDoboz getTermekAzonosito metodusa hibas");
        if (d3.getMelyseg() != 60) hiba("A SpecialisDoboz getMelyseg metodusa hibas eredmenyt ad");
        if (d4.getMelyseg() != 30) hiba("A SpecialisDoboz getMelyseg metodusa hibas eredmenyt ad");
        if (! d3.toString().equals("[3:60cm]")) hiba("A SpecialisDoboz toString metodusa hibas");
        if (! d4.toString().equals("[4:30cm]")) hiba("Az SpecialisDoboz toString metodusa hibas");
        
        //Gyar tesztje
        Gyar gy = new Gyar();
        gy.legyart(d1); gy.legyart(d2); gy.legyart(d3); gy.legyart(d4);
        if (gy.dobozokSzama() != 4) 
            hiba("Nem megfelelo szamu doboz van a futoszalagon 4 doboz legyartasa utan a Gyarban.");

        return ok;
    }

}