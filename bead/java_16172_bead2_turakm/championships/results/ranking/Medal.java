package championships.results.ranking;

public class Medal implements Medals {

    private int golds = 0;
    private int silvers = 0;
    private int bronzes = 0;

    public Medal(int golds, int silvers, int bronzes) {
        this.golds = golds;
        this.silvers = silvers;
        this.bronzes = bronzes;
    }

    @Override
    public int compareTo(Medals obj) {

        if (this.golds < obj.getGolds()) return -1;
        else if (this.golds > obj.getGolds()) return 1;
        else {
            if (this.silvers < obj.getSilvers()) return -1;
            else if (this.silvers > obj.getSilvers()) return 1;
            else {
                if (this.bronzes < obj.getBronzes()) return -1;
                else if (this.bronzes > obj.getBronzes()) return 1;
                else return 0;
            }
        }

    }

    @Override
    public int getGolds() {
        return golds;
    }

    @Override
    public int getSilvers() {
        return silvers;
    }

    @Override
    public int getBronzes() {
        return bronzes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medal medals = (Medal) o;

        if (golds != medals.golds) return false;
        if (silvers != medals.silvers) return false;
        return bronzes == medals.bronzes;
    }

    @Override
    public int hashCode() {
        int result = golds;
        result = 31 * result + silvers;
        result = 31 * result + bronzes;
        return result;
    }

    @Override
    public String toString() {
        return "<" + golds + ", " + silvers + ", " + bronzes + ">";
    }
}
