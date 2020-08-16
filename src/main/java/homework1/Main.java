package homework1;

import homework1.model.*;
import homework1.services.ActionServiceImpl;
import homework1.services.RobotServiceImpl;

public class Main {

    public static void main(String[] args) {

        Treadmill[] treadmill = new Treadmill[1]; // создали массив дорожек
        treadmill[0] = new Treadmill(100);

        Obstacle[] obstacles = new Obstacle[1]; // создали массив препятствий
        obstacles[0] = new Obstacle(2);

        ActionServiceImpl actionService = new ActionServiceImpl(); // получидли параметры препятствий
        RobotServiceImpl robotService = new RobotServiceImpl(actionService, treadmill, obstacles);

        Robot robot = new Robot(200,10); // создали обьект Робот
        robotService.run(robot,treadmill[0]); // Робот бежит
        robotService.jump(robot,obstacles[0]); // Робот прыгает

        Human human = new Human(120, 1); // создали объект Человек
        robotService.run(human,treadmill[0]); // Человек бежит
        robotService.jump(human,obstacles[0]); // Человек прыгает

        Cat cat = new Cat(160, 2); // создали объект кота
        robotService.run(cat,treadmill[0]); // Кот бежит
        robotService.jump(cat,obstacles[0]); // Кот прыгает

        // массив котов
        Cat[] cats = new Cat[]{new Cat(100,3), new Cat(120,4), new Cat(140,5)};
        for (int i = 0; i < cats.length; i++) {
            robotService.run(cats[i],treadmill[0]);
            robotService.jump(cats[i],obstacles[0]);
        }

    }
}
