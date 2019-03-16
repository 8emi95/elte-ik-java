package test;

import java.util.*;
import szallitas.*;

public class Test4 extends Test {

    @Override
    public boolean test() {
        
        Doboz d1 = new Doboz(100);
        Doboz d2 = new Doboz(150);
        IranyitottDoboz d3 = new IranyitottDoboz(300,(byte) 3);
        IranyitottDoboz d4 = new IranyitottDoboz(400, (byte) 4);
        IranyitottDoboz d5 = new IranyitottDoboz(500);
        
        //Szallito tesztje
        Szallito sz = new Szallito();
        if (sz.getDobozok().size() != 0) 
            hiba("Kezdetben a szallitonal nem ures lista jott letre.");
        sz.addUticel((byte) 3);
        if (! sz.felrak(d1))
            hiba("Az elso doboz felrakasa sikertelen, pedig a kozponti raktarba mindenkinek szallitania kell.");
        if (! sz.getDobozok().contains(d1))
            hiba("Az elso doboz felrakott doboz nem kerult be a dobozok listajaba.");
        if (! sz.felrak(d2))
            hiba("Az 2. doboz felrakasa sikertelen, pedig a kozponti raktarba mindenkinek szallitania kell.");
        if (! sz.getDobozok().contains(d2))
            hiba("Az 2. felrakott doboz nem kerult be a dobozok listajaba.");
        if (! sz.felrak(d3))
            hiba("Az 3. doboz felrakasa sikertelen, pedig megfelel a szallito uticeljanak");
        if (! sz.getDobozok().contains(d3))
            hiba("Az 3.felrakott doboz nem kerult be a dobozok listajaba.");
        if (sz.felrak(d4))
            hiba("Az 4. doboz felrakasa sikeres, pedig nem felel meg a szallito uticeljanak");
        if (sz.getDobozok().contains(d4))
            hiba("Az 4. doboz felkerult a dobozok listajaba, pedig nem felel meg a szallito uticeljanak.");
        if (! sz.felrak(d5))
            hiba("Az 5. doboz felrakasa sikertelen, pedig a kozponti raktarba mindenkinek szallitania kell.");
        if (! sz.getDobozok().contains(d5))
            hiba("Az 5. felrakott doboz nem kerult be a dobozok listajaba.");
        if (sz.getDobozok().size() != 4)
            hiba("A vegen 4 doboznak kellene lennie a szallitonal.");
        return ok;
    }
}