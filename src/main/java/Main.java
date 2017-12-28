/**
 * Created by Max on 24.12.2017.
 */
public class Main {

    public static void main(String[] args) {
        float[] x = {1, 2, 3, 4};
        float[] y = {0, 2, 1, 0};
        Lkof[] l = getL(x);
        float integral = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++)
                integral = integral + y[i] * l[i].calculate(x[j]);
        }
        System.out.println(integral);
    }


    public static float[] getY(float[] x) {
        float[] y = new float[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = function(x[i]);
        }
        return y;
    }

    public static float function(float x) {
        return x * x;
    }

    public static Lkof[] getL(float[] x) {
        int num = x.length;
        Lkof[] lkofs = new Lkof[x.length];
        lkofs[0] = new Lkof(x[0], x[1], x[2], x[3]);
        lkofs[1] = new Lkof(x[1], x[0], x[2], x[3]);
        lkofs[2] = new Lkof(x[2], x[0], x[1], x[3]);
        lkofs[3] = new Lkof(x[3], x[0], x[1], x[2]);

        return lkofs;
    }
}
