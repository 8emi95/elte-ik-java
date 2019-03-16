package szallitas;

public class IranyitottDoboz extends Doboz {

    // 2
    public byte raktar;
    // 2
    public byte getRaktar() {return raktar;}
   
    // 2
    public IranyitottDoboz(int ertek, byte raktar) {
        super(ertek);
        this.raktar = raktar;
    }

    // 2,3
    public int getErtek() {
        return (raktar != Gyar.kozpontiRaktar) ? (ertek + (ertek/5)) : ertek;
    }

    // 3
    public IranyitottDoboz(int ertek) {
        this(ertek, Gyar.kozpontiRaktar);
    }
   
}