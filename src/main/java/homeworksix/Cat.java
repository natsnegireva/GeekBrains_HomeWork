package homeworksix;
// бег: кот 200 м
// прыжок: кот 2 м
// плавать: кот не умеет

public class Cat extends Animals {

    public Cat() {
        super();
    }

    @Override
    public void Run(int rlength) {
        System.out.println("Кот бежит " + rlength);
    }

    @Override
    public void Jump(double height) {
        System.out.println("Кот прыгает " + height);
    }
}
