class Program {
    public static void main(String[] args) {
        CelestialObject earth = new CelestialObject(5.972e24, 9.8, 100, 100, 100);
        CelestialObject mars = new CelestialObject(6.417e23, 3.771, 0, 100, 100);
        CelestialObject blackHole = new CelestialObject(8.2e36, 100, 0, 0, 0);

        System.out.println("Nap--Mars tavolsag: " + earth.distance(mars) + " ezer km");
        System.out.println("Nap--Mars kozotti ero: " + earth.attractiveForce(mars)+ " N");
        System.out.println("Fold--fekete lyuk kozotti ero: " + earth.attractiveForce(blackHole) + " N");
        System.out.println("70 kg-os ember sulya a Fold felszinen: " + earth.weight(70) + " N");
        System.out.println("70 kg-os ember sulya a Mars felszinen: " + mars.weight(70) + " N");
        
    }
}
