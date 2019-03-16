package race;

import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

import person.Driver;

public class Race {
    private String name;
    private Driver[] drivers;

    public Race(String fileName) throws Exception {
        Scanner sc = new Scanner(new File(fileName));
        name = sc.nextLine();

        String line = sc.nextLine();
        int c = Integer.parseInt(line);

        drivers = new Driver[c];

        for (int i = 0; i < c; ++i) {
            String driversData = sc.nextLine();
            drivers[i] = new Driver(driversData);
        }
    }

    @Override public String toString() {
        return String.format("Race:(%s, %s)", name, String.join(", ", getDriverStrings()));
    }

    private String[] getDriverStrings() {
        String ret = new String[drivers.length()];
        for (int i = 0; i < ret.length(); ++i) {
            ret[i] = drivers[i].toString();
        }
        return ret;
    }

    public List<Driver> getDriversOfRace(String raceToFind) {
        //
    }

    public List<String> whoHasSameRaces(String driverName) {
        //
    }
}