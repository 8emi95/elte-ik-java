package teszt;

public abstract class Teszt {
	public abstract boolean teszt();
        
        protected boolean ok = true;

        public void hiba(String s) {
            System.err.println(s);
            ok = false;
        }
}
