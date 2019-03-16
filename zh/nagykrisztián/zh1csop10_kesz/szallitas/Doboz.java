package szallitas;

public class Doboz {
    
    //2
    public Doboz(int ertek) {
        this.ertek = ertek;
    }

    //2
    protected int ertek;
    public int getErtek() {return ertek;}
    public void setErtek(int ertek) {this.ertek = ertek;}
    
    //2
    public byte getRaktar() {return Gyar.kozpontiRaktar;}

    //2
    public String toString() {return "[" + getErtek() + "," + getRaktar() + "]";}

}