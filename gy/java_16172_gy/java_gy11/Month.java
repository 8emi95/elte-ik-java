// közös ősosztáy: java.lang.Enum

enum class Moth {
    JAN("januar"),
    FEB("februar"),
    MAR("marcius"),
    APR("aprilis"),
    MAY("majus"),
    JUN("junius"),
    JUL("julius"),
    AUG("augusztus"),
    SEP("szeptember"),
    OCT("oktober"),
    NOV("november"),
    DEC("december");

    public Month(String name) {
        this.name = name;
    }

    private String name;

    public String toString() {
        return name;
    }
}