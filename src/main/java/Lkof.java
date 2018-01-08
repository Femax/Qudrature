import java.util.Arrays;

/**
 * Created by Max on 27.12.2017.
 */
public class Lkof {
    private float x1, x2, x3, x0;

    public static void main(String... args) {
        float[] x = new float[]{-0.96816f, -0.836031f, -0.613371f, -0.324253f, 0, 0.324253f, 0.613371f, 0.836031f, 0.96816f};
        float sum = 0;
        float[] ai = new float[x.length];
        for (int i = 0; i < x.length; i++) {
            ai[i] = (float) (2 / ((1 - Math.pow(x[i], 2)) * Math.pow(legandra(x[i]), 2)));   //<---
        }
        System.out.println("ai" + Arrays.toString(ai));
        System.out.println("x" + Arrays.toString(x));
    }

    private static float legandra(float x) {
        return (float) ((float)45 / 128 * (7 - 308 * Math.pow(x, 2) + 2002 * Math.pow(x, 4) - 4004 * Math.pow(x, 6) + 2431 * Math.pow(x, 8)));
    }
}
