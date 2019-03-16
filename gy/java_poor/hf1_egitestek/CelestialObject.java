class CelestialObject {
    double mass, gravity;
    int x, y, z;

    CelestialObject(double mass, double gravity, int x, int y, int z) {
        this.mass = mass;
        this.gravity = gravity;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    double distance(CelestialObject o) {
        return Math.sqrt(Math.pow(x - o.x, 2) + Math.pow(y - o.y, 2) + Math.pow(z - o.z, 2));
    }

    double attractiveForce(CelestialObject o) {
        return 6.674e-11 * mass * o.mass / Math.pow(distance(o), 2);
    }

    double weight(int w) {
        return w * gravity;
    }
}
