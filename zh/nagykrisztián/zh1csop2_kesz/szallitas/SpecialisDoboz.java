package szallitas;

public class SpecialisDoboz extends Doboz {
    
    //2
    private float szorzo = 1;
    
    //2
    public SpecialisDoboz(byte termekAzonosito, float szorzo) {
        super(termekAzonosito);
        this.szorzo = szorzo;
    }

    //2
    public int getMelyseg() {
        return Math.round(Doboz.szelesseg * szorzo);
    }

    //3
    public SpecialisDoboz(byte termekAzonosito) {
        this(termekAzonosito, 1);
    }
}
