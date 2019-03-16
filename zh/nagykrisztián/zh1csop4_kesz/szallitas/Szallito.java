package szallitas;
import java.util.*;

public class Szallito {

    int nhely;
    int thely;
    
    // 4
    public Szallito(int ossz, int t) {
        this.nhely = ossz - t;
        this.thely = t;
    }
    
    // 4
    private LinkedList<Doboz> normal = new LinkedList<Doboz>();
    // 4
    private LinkedList<Doboz> torekeny = new LinkedList<Doboz>();
    
    // 4
    public LinkedList<Doboz> getDobozok1() {return normal;}
    
    // 4
    public LinkedList<Doboz> getDobozok2() {return torekeny;}
    
    // 4
    public boolean felrak(Doboz d) {
        if (!d.torekenyE() && (nhely - normal.size() > 0)) {
            normal.add(d);
            return true;
        }
        if (thely - torekeny.size() > 0) {
            torekeny.add(d);
            return true;
        }
        return false;
    }
    
    // 5
    public int lepakol(int db) {
        int ertek = 0;
        while (db > 0) {
            if (torekeny.size() > 0) {
                db--;
                ertek += torekeny.get(0).getErtek();
                torekeny.remove(0);
            } else if (normal.size() > 0) {
                db--;
                ertek += normal.get(0).getErtek();
                normal.remove(0);
            } else break;
        }
        return ertek;
    }
}