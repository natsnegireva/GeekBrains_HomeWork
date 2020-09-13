package homeworkthree5;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT = 0;
    private static boolean winnerFound;
    private static final Lock win = new ReentrantLock();
    private final Race race;
    private final int speed;
    private final String name;
    private final CyclicBarrier cyclicBarrier;

    public Car(Race race, int speed, CyclicBarrier cyclicBarrier) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник # " + CARS_COUNT;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
            cyclicBarrier.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            cyclicBarrier.await();
            checkWinner(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //проверка победителя
    private static void checkWinner(Car c) {
        if (!winnerFound) {
            System.out.println(c.name + " - Победил");
            winnerFound = true;
        }
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}