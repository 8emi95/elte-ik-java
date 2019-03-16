package szallitas;

public class Doboz {
    
    //2
    public static final int szelesseg = 50;

    //2
    public int getMelyseg() {return szelesseg;}

    //2
    private byte termekAzonosito;

    //2
    public byte getTermekAzonosito() {return termekAzonosito;}

    //2
    public void setTermekAzonosito(byte id) {termekAzonosito = id;}

    //2
    public Doboz(byte id) {termekAzonosito = id;}

    //2
    public String toString() {
        return "[" + termekAzonosito + ":" + getMelyseg() + "cm]";
    }
}
