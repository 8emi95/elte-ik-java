package test;

public abstract class Test {
	public abstract boolean test();
        
        protected boolean ok = true;

        public void hiba(String s) {
            System.err.println(s);
            ok = false;
        }
}
