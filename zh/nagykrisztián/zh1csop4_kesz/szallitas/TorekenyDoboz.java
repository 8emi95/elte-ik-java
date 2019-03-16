package szallitas;

public class TorekenyDoboz extends Doboz {

    // 2
    public static final int ertekNovekedes = 20;
    
    // 2
    public TorekenyDoboz(int ertek) {
        super(ertek);
    }
    
    // 3
    private boolean torekeny = true;
    
    // 3
    public TorekenyDoboz(int ertek, boolean torekeny) {
        this(ertek);
        this.torekeny = torekeny;
    }
    
    // 2 , 3
    public boolean torekenyE() {return torekeny;}
    
    // 2, 3
    public int getErtek() {
        return (torekenyE()) ? ((ertek*(100+ertekNovekedes) / 100)) : ertek;
    }   
}