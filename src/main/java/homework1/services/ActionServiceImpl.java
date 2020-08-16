package homework1.services;

import homework1.model.Obstacle;
import homework1.model.Treadmill;

public class ActionServiceImpl {
    public int getTreadmillLength(Treadmill treadmill) {
        return treadmill.getLength();
    }

    public int getObstacleHeight(Obstacle obstacle) {
        return obstacle.getHeight();
    }
}
