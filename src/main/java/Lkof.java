/**
 * Created by Max on 27.12.2017.
 */
public class Lkof {
    private float x1, x2, x3, x0;

    public Lkof(float x1, float x2, float x3, float x0) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x0 = x0;
    }

    public float calculate(float x) {
        return (x - x1) * (x - x2) * (x - x3) / ((x0 - x1) * (x0 - x2) * (x0 - x3));
    }
}
