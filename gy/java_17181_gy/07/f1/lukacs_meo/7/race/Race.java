package race;

import person.Driver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Race {
    private String name;
    private Driver[] drivers;
    
    public Race(String filename) throws Exception {
        try (Scanner scanner = new Scanner(new File(filename));) {
            name = scanner.nextLine();
            
            int n = Integer.parseInt(scanner.nextLine());
            
            drivers = new Driver[n];
            
            for (int i = 0; i < n; i++) {
                String driverData = scanner.nextLine();
                drivers[i] = new Driver(driverData);
            }
        }
    }
    
    public String toString() {
        String driversLines = String.join(", ", getDriverStrings());
        return String.format("Race:(%s, %s)", name, driversLines);
    }
    
    private String[] getDriverStrings() {
        String[] result = new String[drivers.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = drivers[i].toString();
        }
        return result;
    }
    
    public List<Driver> getDriversOfRace(String raceToFind) {
        List<Driver> result = new ArrayList<>();
        for (Driver driver : drivers) {
            if (driver.hasRace(raceToFind)) {
                result.add(driver);
            }
        }
        return result;
    }
    
    public List<String> whoHasSameRaces(String driverName) {
      return null;
    }
}
