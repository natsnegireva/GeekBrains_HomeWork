package homework5;

public class ArrayFloat {

    public static int size = 100000;
    public static final int h = size / 2;
    public static float[] arr;

    public static void main(String[] args) {
        methodOne();
        methodTwo();
    }

    public static float[] myArr() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (float) 1.0;
        }
        return arr;
    }

    public static void methodOne() {
        CountCount count = new CountCount();
        Thread thread1 = new Thread( (Runnable) () -> {
            synchronized (count) {
                while (count.isWork) {
                    long a = System.currentTimeMillis();
                    try {
                        for (int i = 0; i < size; i++) {
                            arr[i] = (float) (arr[i] * Math.sin( 0.2f + i / 5 ) * Math.cos( 0.2f + i / 5 ) * Math.cos( 0.4f + i / 2 ));
                        }
                    } catch (NullPointerException e) {
                        e.fillInStackTrace();
                    }
                    long b = System.currentTimeMillis();
                    System.out.println( "Обработка первого метода длилась " + (b - a) + " ms." );
                    count.notifyAll();
                    try {
                        count.wait();
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }
                    count.isWork = false;
                }
            }
        } );
        thread1.start();
    }

    public static void methodTwo() {
        float[] arr = myArr();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        CountCount count1 = new CountCount();
        Thread thread2 = new Thread( (Runnable) () -> {
            synchronized (count1) {
                while (count1.isWork) {
                    long a = System.currentTimeMillis();
                    System.arraycopy( arr, 0, arr1, 0, h );
                    for (int i = 0; i < h; i++) {
                        arr1[i] = (float) (arr1[i] * Math.sin( 0.2f + i / 5 ) * Math.cos( 0.2f + i / 5 ) * Math.cos( 0.4f + i / 2 ));
                    }
                    System.arraycopy( arr1, 0, arr, 0, h );
                    long c = System.currentTimeMillis();
                    System.out.println( "Обработка первого потока 2 метода длилась " + (c - a) + " ms." );
                    count1.notifyAll();
                    try {
                        count1.wait();
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }
                }
            }
        } );

        Thread thread3 = new Thread( (Runnable) () -> {
            synchronized (count1) {
                while (count1.isWork) {
                    long b = System.currentTimeMillis();
                    System.arraycopy( arr, h, arr2, 0, h );
                    for (int i = 0; i < h; i++) {
                        arr2[i] = (float) (arr2[i] * Math.sin( 0.2f + i / 5 ) * Math.cos( 0.2f + i / 5 ) * Math.cos( 0.4f + i / 2 ));
                    }
                    System.arraycopy( arr2, 0, arr, h, h );
                    long d = System.currentTimeMillis();
                    System.out.println( "Обработка второго потока 2 метода длилась " + (d - b) + " ms." );
                    count1.notifyAll();
                    try {
                        count1.wait();
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }
                    count1.isWork = false;
                }
            }
        } );
        thread2.start();
        thread3.start();

    }
}


class CountCount {
    boolean isWork = true;

}
