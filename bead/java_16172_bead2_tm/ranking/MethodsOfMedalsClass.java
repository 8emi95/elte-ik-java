package bead.championships.results.ranking;

import java.util.Objects;

public class MethodsOfMedalsClass implements Medals {

    private int golds;
    private int silvers;
    private int bronzes;

    public MethodsOfMedalsClass(int golds, int silvers, int bronzes) {
        this.golds = golds;
        this.silvers = silvers;
        this.bronzes = bronzes;
    }

    @Override
    public int compareTo(Medals obj) {
        if (this.getGolds() == obj.getGolds()) {
            if (this.getSilvers() == obj.getSilvers()) {
                if (this.getBronzes() == obj.getBronzes()) {
                    return 0;
                } else if (this.getBronzes() > obj.getBronzes()) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (this.getSilvers() > obj.getSilvers()) {
                return 1;
            } else {
                return -1;
            }
        } else if (this.getGolds() > obj.getGolds()) {
            return 1;
        } else {
            return -1;
        }

    }

    @Override
    public int getGolds() {
        return this.golds;
    }

    @Override
    public int getSilvers() {

        return this.silvers;
    }

    @Override
    public int getBronzes() {
        return this.bronzes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getGolds(), this.getSilvers(), this.getBronzes());
    }

    @Override
    public String toString() {
        return "<" + getGolds() + ", " + getSilvers() + ", " + getBronzes() + ">";
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj != null || this != null) && obj instanceof Medals) {
            if (this.getClass() == obj.getClass()) {
                if (this.compareTo((Medals)obj) == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
