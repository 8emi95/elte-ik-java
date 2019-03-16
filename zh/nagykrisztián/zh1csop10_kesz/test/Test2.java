package test;

import szallitas.*;

public class Test2 extends Test {

    @Override
    public boolean test() {
        
        //Doboz tesztje
        Doboz d1 = new Doboz(100);
        Doboz d2 = new Doboz(150);

        if (d1.getErtek() != 100) hiba("A Doboz getErtek metodusa hibas");
        d2.setErtek(200);
        if (d2.getErtek() != 200) hiba("A Doboz getErtek v. setErtek metodusa hibas");
        if (d1.getRaktar() != 1) hiba("A Doboz getRaktar metodusa hibas");
        if (d2.getRaktar() != 1) hiba("A Doboz getRaktar metodusa hibas");
        if (! d1.toString().equals("[100,1]")) hiba("A Doboz(1) toString metodusa hibas");
        if (! d2.toString().equals("[200,1]")) hiba("A Doboz(2) toString metodusa hibas");


        //IranyitottDoboz tesztje
        IranyitottDoboz d3 = new IranyitottDoboz(300,(byte) 3);
        Doboz d4 = new IranyitottDoboz(400,(byte) 4);
        if (d3.getErtek() != (360)) hiba("Az IranyitottDoboz getErtek metodusa hibas");
        if (d4.getErtek() != (480)) hiba("Az IranyitottDoboz getErtek metodusa hibas");
        if (d3.getRaktar() != 3) hiba("Az IranyitottDoboz getRaktar metodusa hibas");
        if (d4.getRaktar() != 4) hiba("Az IranyitottDoboz getRaktar metodusa hibas");
        if (! d3.toString().equals("[360,3]")) hiba("Az IranyitottDoboz toString metodusa hibas");
        if (! d4.toString().equals("[480,4]")) hiba("Az IranyitottDoboz toString metodusa hibas");
        //Gyar tesztje
        if (Gyar.kozpontiRaktar != 1) 
            hiba("A Gyar kozpontiRaktar nevu osztályszintu valtozojanak nem megfelelo a kezdoerteke");
        Gyar gy = new Gyar();
        gy.legyart(d1); gy.legyart(d2); gy.legyart(d3); gy.legyart(d4);
        if (gy.dobozokSzama() != 4) 
            hiba("Nem megfelelo szamu doboz van a futoszalagon 4 doboz legyartasa utan a Gyarban.");

        return ok;
    }

}