package szallitas;

import java.util.*;

public class Gyar {
    
    //2
    private List<Doboz> szalag = new LinkedList<Doboz>();
    
    //2
    public void legyart(Doboz d) {szalag.add(d);}

    //2
    public int dobozokSzama() {return szalag.size();}

    //3
    public Doboz getMeretAlattiDoboz(int meret) {
        for (Doboz d : szalag) {
            if (d.getMelyseg() <= meret) return d; 
        }
        return null;
    }

    //3
    public String toString() {
        String s = "";
        if (szalag.size() > 0) s+= szalag.get(0).toString();
        for (int i=1; i < szalag.size(); i++) {
            s += "_" + szalag.get(i).toString();
        }
        return s;
    }

    //5
    public int elszallit(Szallito sz) {
        int db = 0;
        while (true) {
            Doboz d = getMeretAlattiDoboz(sz.getUresHossz());
            if (d == null) break;
            db++;
            sz.felrak(d);
            szalag.remove(d);
        }
        return db;
    }
}
