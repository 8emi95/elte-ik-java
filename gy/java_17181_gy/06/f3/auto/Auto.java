package auto;

import auto.utils.Color;

public class Auto {
    private String license;
    private Color color;
    private int maxSpeed;

    public static int OBJECT_COUNT = 0;

    public Auto(String license, Color color, int maxSpeed) {
        this.license = license;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public Auto() {
        Auto a = new Auto("AAA-000", Color.BLUE, 120);
    }

    public static boolean compareTo(Auto first, Auto second) {
        return first.maxSpeed > second.maxSpeed;
    }
}