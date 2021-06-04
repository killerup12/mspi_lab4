public class SimulateShot {
    private final double r;

    public SimulateShot(double R) {
        if (R <= 0) throw new IllegalArgumentException();
        this.r = R;
    }

    public boolean shotAt(double x, double y) {
        if (x <= 0 && y >= 0 && y <= 2 * x + r) {
            return true;
        } else if (x >= 0 && y >= 0 && y <= r / 2 && x <= r) {
            return true;
        } else return x <= 0 && y <= 0 && r * r / 4 >= x * x + y * y;
    }
}
