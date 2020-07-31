package homeworkone1.interfaces;

import homeworkone1.model.*;

public interface RobotService {

    void run(Robot robot, Treadmill treadmill);
    void jump(Robot robot, Obstacle obstacle);

    void run(Human human, Treadmill treadmill);
    void jump(Human human, Obstacle obstacle);

    void run(Cat cat, Treadmill treadmill);
    void jump(Cat cat, Obstacle obstacle);

}