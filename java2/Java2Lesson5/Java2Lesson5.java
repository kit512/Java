package geekbrains.Java2Lesson5;


public class Java2Lesson5 {
    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;

    public static void main(String s[]) {
        Java2Lesson5 o = new Java2Lesson5();
        o.oneThread();
        o.twoThreads();
    }

    public void oneThread() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        calculate(arr);
        System.out.println("Метод с одним потоком " + (System.currentTimeMillis() - a));
    }

    public void twoThreads() {
        float[] arr = new float[SIZE];
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        new Thread(() -> calculate(a1)).start();
        new Thread(() -> calculate(a2)).start();


        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        System.out.println("Метод с двумя потоками " + (System.currentTimeMillis() - a));
    }

    public float[] calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }
}