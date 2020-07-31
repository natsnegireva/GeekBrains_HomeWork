package homework1;

public class Main {
    // Создайте два массива: с участниками и препятствиями,
    // и заставьте всех участников пройти этот набор препятствий.
    // ограничения на бег и прыжки
    // Если участник не смог пройти одно из препятствий, то дальше по списку препятствий он не идет.

    public static void main(String[] args) {
/*        SubAbstract cats = new Cat(100,2);
        SubAbstract humans = new Human(150,3);
        SubAbstract robots = new Robot(300, 10);
        Treadmill treadmill = new Treadmill(10);
        Obstacle obstacle = new Obstacle(10);*/

        SubAbstract[][] objects = new SubAbstract[][]{{new Cat(100,2)}, {new Human(150,1)}, {new Robot(200,3)}};
        Mechanics[] mechanics = new Mechanics[]{new Treadmill(120), new Obstacle(1)};
        while (!Cat.stopRun()) {
            Cat.run();
        }
        while (!Cat.stopJump()) {
            Cat.jump();
        }
        while (!Human.stopRun()) {
            Human.run();
        }
        while (!Human.stopJump()) {
            Human.jump();
        }
        while (!Robot.stopRun()) {
            Robot.run();
        }
        while (!Robot.stopJump()) {
            Robot.jump();
        }

    }
}
