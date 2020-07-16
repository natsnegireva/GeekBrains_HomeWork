package homeworksix;

public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

// Кот бежит и прыгает
        cat1.Run(200);
        cat1.Jump(2);

// Первая собака бежит(случайное значение от 400 до 600), прыгает и плавает
        dog1.Run(0);
        dog1.Jump(0.5);
        dog1.Swim(10);

// Вторая собака бежит (случайное значение от 400 до 600), прыгает и плавает
        dog2.Run(0);
        dog2.Jump(0.5);
        dog2.Swim(10);

    }
}
