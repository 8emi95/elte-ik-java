package test;

import java.util.*;
import szallitas.*;

public class Test3 extends Test {

    @Override
    public boolean test() {
        
        Doboz d1 = new Doboz(100);
        Doboz d2 = new Doboz(150);
        IranyitottDoboz d3 = new IranyitottDoboz(300,(byte) 3);
        Gyar gy = new Gyar();
       

        //Gyar tesztje
        if (gy.getElsoDoboz() != null) 
            hiba("A Gyar getElsoDoboz metodusa ures futoszalagra nem mukodik jol.");

        gy.legyart(d1); 
       
        if (! gy.toString().equals("[100,1]")) 
            hiba("A Gyar toString metodusa hibas.");

        gy.legyart(d2); gy.legyart(d3);
        
        if (gy.getElsoDoboz() != d1) 
            hiba("A Gyar getElsoDoboz metodusa nem az elso dobozt adja viszza.");
        if (! gy.toString().equals("[100,1]_[150,1]_[360,3]")) 
            hiba("A Gyar toString metodusa hibas.");


        //IranyitottDoboz tesztje
        
        Doboz d4 = new IranyitottDoboz(400); //a kozponti raktartba megy
        if (d3.getErtek() != (360)) hiba("Az IranyitottDoboz getErtek metodusa hibas");
        if (d4.getErtek() != (400)) hiba("Az IranyitottDoboz getErtek metodusa hibas");
        if (d3.getRaktar() != 3) hiba("Az IranyitottDoboz getRaktar metodusa hibas");
        if (d4.getRaktar() != 1) hiba("Az IranyitottDoboz getRaktar metodusa hibas");
        if (! d3.toString().equals("[360,3]")) hiba("Az IranyitottDoboz toString metodusa hibas");
        if (! d4.toString().equals("[400,1]")) hiba("Az IranyitottDoboz toString metodusa hibas");
        
        return ok;
      
    }
}