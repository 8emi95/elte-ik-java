package championships.results;

public class Competitor implements Participant {

    private String name;
    private String nation;

    public Competitor(String name, String nation) {
        if ((name != null && !name.isEmpty()) && (nation != null && !nation.isEmpty())) {
            this.name = name;
            this.nation = nation;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNation() {
        return nation;
    }
}
