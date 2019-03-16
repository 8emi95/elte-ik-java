package person;

import java.util.Arrays;

public class Driver {
    public static final Driver javaDriver = new Driver("James Gosling", new String[]{ "Kanada Open" });
    private String name;
    private String[] races;
    
    public Driver(String data) {
        this(data.split(","));
    }
    
    private Driver(String[] parts) {
        this(parts[0], Arrays.copyOfRange(parts, 1, parts.length));
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
        return races.clone();
    }
    
    public void setRaces(String[] races) {
        this.races = races.clone();
    }
    
    public String toString() {
        return String.format("Driver[%s, %s]", getName(), Arrays.toString(getRaces()));
    }
    
    public boolean hasRace(String raceToFind) {
        for (String race : getRaces()) {
            if (race.equals(raceToFind))
                return true;
        }
        return false;
    }
}
