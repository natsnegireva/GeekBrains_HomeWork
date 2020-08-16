package homework5;

public class ArrayFloat {

    public static int size = 10000000;
    public static final int h = size / 2;
    public static float[] arr;

    public static void main(String[] args) {
        methodOne();
        methodTwo();
    }

    private static float[] myArr() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (float) 1.0;
        }
        return arr;
    }

    public static void methodOne() {
        ArrayFloat aFloat = new ArrayFloat();
        long a = System.currentTimeMillis();
        Thread thread1 = new Thread( (Runnable) () -> {
            for (int i = 0; i < size; i++) {
                arr[i] = (float) (arr[i] * Math.sin( 0.2f + i / 5 ) * Math.cos( 0.2f + i / 5 ) * Math.cos( 0.4f + i / 2 ));
            }
        } );
        thread1.start();
        long b = System.currentTimeMillis();
        System.out.println( "Обработка первого метода длилась " + (b - a) + " ms." );
    }

    public static void methodTwo() {
        float[] arr = myArr();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        Thread thread2 = new Thread( (Runnable) () -> {
            long a = System.currentTimeMillis();
            System.arraycopy( arr, 0, arr1, 0, h );
            for (int i = 0; i < h; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin( 0.2f + i / 5 ) * Math.cos( 0.2f + i / 5 ) * Math.cos( 0.4f + i / 2 ));
            }
            System.arraycopy( arr1, 0, arr, 0, h );
            System.out.println( "Обработка первого потока 2 метода длилась " + (System.currentTimeMillis() - a) + " ms." );

        } );

        Thread thread3 = new Thread( (Runnable) () -> {
            long a = System.currentTimeMillis();
            System.arraycopy( arr, h, arr2, 0, h );
            for (int i = 0; i < h; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin( 0.2f + i / 5 ) * Math.cos( 0.2f + i / 5 ) * Math.cos( 0.4f + i / 2 ));
            }
            System.arraycopy( arr2, 0, arr, h, h );
            System.out.println( "Обработка первого потока 2 метода длилась " + (System.currentTimeMillis() - a) + " ms." );

        } );
        thread2.start();
        thread3.start();

        try {
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

