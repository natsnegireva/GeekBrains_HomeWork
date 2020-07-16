package homeworksix;
// бег: собака 500 м
// прыжок: собака 0.5 м
// плаванье: собака 10 м

import java.util.Random;

public class Dog extends Animals {
    public int slength;

    public Dog() {
        super();
    }

    //  Добавить животным разброс в ограничениях.
    //  То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
    @Override
    public void Run(int rlength) {
        int min = 400;
        int max = 600;
        Random rand = new Random();
        rlength = rand.ints(min,(max+1)).findFirst().getAsInt();
        System.out.println("Собака бежит " + rlength);
    }

    @Override
    public void Jump(double height) {
        System.out.println("Собака прыгает " + height);
    }

    @Override
    public void Swim(int slength) {
        System.out.println("Собака плавает " + slength);
    }
}
