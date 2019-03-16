import person.Driver;
import race.Race;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        String filename;
        if (args.length > 0) {
            filename = args[0];
        } else {
            System.out.print("Fajlnev: ");
            filename = System.console().readLine();
        }
        
        Race race = new Race(filename);
        System.out.println(race);
        
        System.out.print("Verseny: ");
        String raceToFind = System.console().readLine();
        List<Driver> drivers = race.getDriversOfRace(raceToFind);
        
        for (Driver driver : drivers) {
            System.out.println(driver.getName());
        }
    }
}
