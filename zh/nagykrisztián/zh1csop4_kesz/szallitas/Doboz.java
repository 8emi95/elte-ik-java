package szallitas;

public class Doboz {
    
    // 2
    public Doboz(int ertek) {
        this.ertek = ertek;
    }
    
    // 2
    protected int ertek;
    public int getErtek() {return ertek;}
    public void setErtek(int ertek) {this.ertek = ertek;}
    
    // 2
    public boolean torekenyE() {return false;}
    
    // 2
    public String toString() {
        String str = "";
        if (torekenyE()) str = "!";
        return "[" + str + getErtek() + "]";
    }
}