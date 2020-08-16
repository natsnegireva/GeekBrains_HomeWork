package homework1.services;

import homework1.interfaces.RobotService;
import homework1.model.*;

public class RobotServiceImpl implements RobotService {
    ActionServiceImpl actionService; // передаем получение значений Дорожки и Стены

    public RobotServiceImpl(ActionServiceImpl actionService) {
        this.actionService = actionService;
    }

    public RobotServiceImpl(ActionServiceImpl actionService, Treadmill[] treadmill, Obstacle[] obstacles) {
    }
    @Override
    public void run(Robot robot, Treadmill treadmill) {
        if (robot.getMaxrun() < treadmill.getLength()) {
            System.out.println("робот не может бежать");
        } else {
            System.out.println("робот бежит " + robot.getMaxrun() + " метров.");
        }
    }

    @Override
    public void jump(Robot robot, Obstacle obstacle) {
        if (robot.getMaxjump() < obstacle.getHeight()) {
            System.out.println("робот не может бежать");
        } else {
            System.out.println("робот прыгает " + robot.getMaxjump() + " метров.");
        }
    }

    @Override
    public void run(Human human, Treadmill treadmill) {
        if (human.getMaxrun() < treadmill.getLength()) {
            System.out.println("человек не может бежать");
        } else {
            System.out.println("человек бежит " + human.getMaxrun() + " метров.");
        }
    }

    @Override
    public void jump(Human human, Obstacle obstacle) {
        if (human.getMaxjump() < obstacle.getHeight()) {
            System.out.println("человек не может бежать");
        } else {
            System.out.println("человек прыгает " + human.getMaxjump() + " метров.");
        }
    }

    @Override
    public void run(Cat cat, Treadmill treadmill) {
        if (cat.getMaxrun() < treadmill.getLength()) {
            System.out.println("кот не может бежать");
        } else {
            System.out.println("кот бежит " + cat.getMaxrun() + " метров.");
        }
    }

    @Override
    public void jump(Cat cat, Obstacle obstacle) {
        if (cat.getMaxjump() < obstacle.getHeight()) {
            System.out.println("кот не может бежать");
        } else {
            System.out.println("кот прыгает " + cat.getMaxjump() + " метров.");
        }
    }

}
