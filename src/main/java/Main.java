/**
 * Created by Max on 24.12.2017.
 */
public class Main {

    public static void main(String[] args) {
        float leftx = -3;
        float rightx = 3;
        float step = 0.25f;
        float integral = 0;
        float[] x = getMassiveX(leftx, rightx, step);
        float[] y = getMassiveY(x);
        System.out.println("Ньютона-Котеса n = 0 :  " + n1(x, y, leftx, rightx));
        System.out.println("Ньютона-Котеса n = 1 :  " + n2(x, y, leftx, rightx));
        System.out.println("Ньютона-Котеса n = 2 :  " + n3(x, y, leftx, rightx));
        System.out.println("Лежандра: " + methodlegandra(leftx, rightx));
    }

    private static float[] getMassiveY(float[] x) {
        float[] y = new float[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = function1(x[i]);
        }
        return y;
    }

    private static float[] getMassiveX(float leftx
            , float rightx, float step) {
        int length = (int) ((rightx + Math.abs(leftx)) / step) + 1;
        float[] massive = new float[length];
        int i = 0;
        float buf = leftx;
        while (buf <= rightx) {
            massive[i] = buf;
            buf = buf + step;
            i++;
        }
        return massive;
    }

    public static float[] getMassiveY2(float[] x) {
        float[] y = new float[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = function2(x[i]);
        }
        return y;
    }

    public static float function1(float x) {
        if (x == 0) return 1;
        return (float) (Math.sin(x) / x);
    }

    public static float function2(float x) {
        return Math.abs(x);
    }

    public static float n1(float[] x, float[] y, float a, float b) {
        float sum = 0;
        for (int i = 0; i < y.length; i++) {
            sum = sum + y[i];
        }
        return (b - a) / x.length * sum;
    }

    public static float n2(float[] x, float[] y, float a, float b) {
        float sum = 0;
        float h = x[1] - x[0];
        for (int i = 1; i < y.length - 1; i++) {
            sum += y[i];
        }
        return h * ((y[0] + y[y.length - 1]) / 2 + sum);
    }

    public static float n3(float[] x, float[] y, float a, float b) {
        float sum = 0;
        float h = x[1] - x[0];
        sum += y[0] + y[y.length - 1];
        for (int i = 1; i < y.length - 1; i++) {
            if (i % 2 != 0) sum += y[i] * 4;
            else sum += y[i] * 2;
        }
        return h * sum / 3;
    }

//    public static float funlagrandg(float x, float[] x0, float[] y) {
//        float tempX = 1;
//        for (int i = 0; i < x0.length; i++) {
//            for (int j = 0; j < x0.length; j++) {
//                if (i != j) tempX = tempX * (x - x0[j]) / (x0[i] - x0[j]);
//                else tempX = tempX * (x - x0[j]);
//            }
//            tempX = tempX * y[i];
//        }
//        return tempX;
//    }

    public static float methodlegandra(float a, float b) {
        float[] x = new float[]{-0.96816f, -0.836031f, -0.613371f, -0.324253f, 0, 0.324253f, 0.613371f, 0.836031f, 0.96816f};
        float sum = 0;
        float[] ai = new float[x.length];
        for (int i = 0; i < x.length; i++) {
            ai[i] = (float) (2 / ((1 - Math.pow(x[i], 2)) * Math.pow(legandra(x[i]), 2)));   //<---
        }
        for (int i = 0; i < x.length; i++) {
            sum += ai[i] * function1((b - a) / 2 * x[i] + (b + a) / 2);         // <---
        }
        return (b - a) / 2 * (sum);
    }


//    public static float methodlegandra(float a, float b) {
//        float[] x3 = new float[]{-0.9324700f, -0.6612094f, -0.238614f, 0.2386142f, 0.6612094f, 0.9324700f};
//        float[] ai2 = new float[]{0.1713245f, 0.3607616f, 0.4679140f, 0.4679140f, 0.3607616f, 0.1713245f};
//        float sum = 0;
//        float ra = (b - a) / 2;
//        float su = (a + b) / 2;
//        for (int i = 0; i < x3.length; i++) {
//            sum += ai2[i] * function1(b - a / 2 * x3[i] + a + b / 2);
//        }
//        return (b - a) / 2 * (sum);
//    }


    private static float legandra(float x) {
        return (float) ((float) 45 / 128 * (7 - 308 * Math.pow(x, 2) + 2002 * Math.pow(x, 4) - 4004 * Math.pow(x, 6) + 2431 * Math.pow(x, 8)));
    }

    public static float dlegandra6(float x) {
        return (float) ((float) 21 / 8 * x * (33 * Math.pow(x, 4) - 30 * Math.pow(x, 2) + 5));
    }
}
