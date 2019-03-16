class GreetingsA {
	public static void main(String[] args) {
		System.out.println("Szia! Hogy hivnak?"); //hosszu ekezet kerulese winfoson
		String name = System.console().readLine(); //console metodus, programfutas megall es beker egy sort
		//nev eltarolasa valtozoban
		System.out.println("Udv " + name + ", mi ujsag?");
	}
}