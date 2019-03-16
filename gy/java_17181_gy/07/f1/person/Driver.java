package person;

import java.util.Arrays;

public class Driver {
    public static final Driver javaDriver = new Driver("James Gosling,", new String[]{"Kanada Open"});
    private String name;
    private String[] races;

    public Driver(String data) {
        this(data.split(","));
    }

    private Driver(String[] parts) {
        //
    }

    public Driver(String name, String[] races) {
        setName(name);
        setRaces(races);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getRaces() {
        return races;
    }

    public void setRaces(String[] races) {
        this.races = races.clone();
    }

    @Override public String toString() {
        return String.format("Driver[%s, %s]", getName(), Arrays.toString(getRaces()));
    }

    public boolean hasRace(String raceToFind) {
        for (String race : getRaces()) {
            if (race.equals(raceToFind)) {
                return true;
            }
        }
        return false;
    }
}