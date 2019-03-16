package szallitas;
import java.util.*;

public class Szallito {

    // 4
    private Set<Byte> uticelok = new HashSet<Byte>();

    // 4
    public Szallito() { uticelok.add(Gyar.kozpontiRaktar);}
    
    // 4
    private LinkedList<Doboz> szallitmany = new LinkedList<Doboz>();
    // 4
    public LinkedList<Doboz> getDobozok() {return szallitmany;}

    // 4
    public void addUticel(byte ujcel) {uticelok.add(ujcel);}

    // 4
    public boolean felrak(Doboz d) {
        if (uticelok.contains(d.getRaktar())) {
            szallitmany.add(d);
            return true;
        } else
            return false;
    }

    // 5
    public int lepakol(byte raktar) {
        List<Doboz> lepakolandok = new ArrayList<Doboz>();
        int ertek = 0;
        for (Doboz d : szallitmany) {
            if (d.getRaktar() == raktar) {
                lepakolandok.add(d);
            }
        }
        for (Doboz d : lepakolandok) {
            szallitmany.remove(d);
            ertek += d.getErtek();
        }
        return ertek;
    }
}