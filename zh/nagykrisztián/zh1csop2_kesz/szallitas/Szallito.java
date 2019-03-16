package szallitas;

import java.util.*;

public class Szallito {
    
    //4
    private LinkedList<Doboz> dobozok = new LinkedList<Doboz>();
    //4
    private int hossz = 10 * Doboz.szelesseg;
    //4
    private int dobozhossz = 0;
    public int getUresHossz() {return hossz-dobozhossz;}
    
    //4
    public Szallito() {}
    
    //4
    public Szallito(int hossz) {this.hossz = hossz;}

    //4
    public LinkedList<Doboz> getDobozok() {return dobozok;}

    //4
    public boolean felrak(Doboz d) {
        if (hossz - dobozhossz >= d.getMelyseg()) {
            dobozok.add(d);
            dobozhossz += d.getMelyseg();
            return true;
        }
        return false;
    }

    //5
    public int lepakol(byte id) {
        List<Doboz> lepakolando = new ArrayList<Doboz>();
        int osszmelyseg = 0;
        for (Doboz d : dobozok) {
            if (d.getTermekAzonosito() == id) {
                lepakolando.add(d);
                int m = d.getMelyseg();
                osszmelyseg += m;
                dobozhossz -= m;
            }
        }
        for (Doboz d : lepakolando) {
            dobozok.remove(d);
        }
        return osszmelyseg * Doboz.szelesseg;
    }
    
}
