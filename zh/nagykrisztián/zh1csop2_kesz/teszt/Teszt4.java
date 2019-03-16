package teszt;

import java.util.*;
import szallitas.*;

public class Teszt4 extends Teszt {

    @Override
    public boolean teszt() {

        Doboz d1 = new Doboz((byte) 1); //50
        Doboz d2 = new Doboz((byte) 2); //50
        SpecialisDoboz d3 = new SpecialisDoboz((byte) 3, (float) 1.2); //60
        Doboz d4 = new SpecialisDoboz((byte) 4, (float) 0.6); //30
        Doboz d5 = new SpecialisDoboz((byte) 5); //50
        
        //Szallito tesztje
        Szallito sz1 = new Szallito();
        
        if (sz1.getDobozok().size() != 0) 
            hiba("Kezdetben a szallitonal nem ures lista jott letre.");

        for (int i=0; i<10; i++) {
            boolean b = sz1.felrak(new Doboz((byte) 1));
            if (!b) {
                hiba("Az alapertelmezett hosszusagu szallitora nem fert fel 10 normal doboz");
                break;
            }
        }
        if (sz1.getDobozok().size() != 10)
            hiba("Az sz1 szalloton most 10 doboznak kellene lennie,"+
                 "de a getDobozok metodus mas hosszusagu listat ad vissza");
        
        if (sz1.felrak(d1))
            hiba("Egy olyan doboz felrakasa sikeres, ami mar nem fer a szallitora.");
        if (sz1.getDobozok().contains(d1))
            hiba("A d1 doboz felkerult a szallito listajara, pedig mar nem fert fel");

        Szallito sz2 = new Szallito(95);
        if (! (sz2.felrak(d3) && sz2.felrak(d4)))
            hiba("Egy 95 hosszu szallitora fel kellett volna fernie egy 60 és egy 30 meretu doboznak.");
        if (! sz2.getDobozok().contains(d3))
            hiba("A d3 doboz nem kerult fel az sz2 szallito listajara, pedig feltettuk.");
        if (! sz2.getDobozok().contains(d4))
            hiba("A d4 doboz nem kerult fel az sz2 szallito listajara, pedig feltettuk.");
        if (sz2.felrak(d1))
            hiba("Egy olyan doboz felrakasa sikeres, ami mar nem fer a szallitora.");
        if (sz2.getDobozok().contains(d1))
            hiba("A d1 doboz felkerult a szallito listajara, pedig mar nem fert fel");

        return ok;
    }
}