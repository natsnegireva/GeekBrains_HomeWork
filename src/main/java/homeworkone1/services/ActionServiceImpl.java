package homeworkone1.services;

import homeworkone1.model.Obstacle;
import homeworkone1.model.Treadmill;

public class ActionServiceImpl {
    public int getTreadmillLength(Treadmill treadmill) {
        return treadmill.getLength();
    }

    public int getObstacleHeight(Obstacle obstacle) {
        return obstacle.getHeight();
    }
}
