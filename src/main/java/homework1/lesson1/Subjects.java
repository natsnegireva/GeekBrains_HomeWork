package homework1.lesson1;

public abstract class Subjects{
    // изучение вложенных классов (НЕ ДОМАШНЕЕ ЗАДАНИЕ)

    private static Object Subjects;

    static class Cat {
        public Cat(int maxrun, int maxjump) {
        }
    }

    static class Human {
        public Human(int maxrun, int maxjump) {
        }
    }

    static class Robot {
        public Robot(int maxrun, int maxjump) {
        }
    }

    public Subjects(Object cat, Object human, Object robot) {

    }

    public static void run(int maxrun, int length) {
        if (maxrun <= length) {
            if (Subjects instanceof Cat) {
                System.out.println("Кот бежит");
            }
            if (Subjects instanceof Human) {
                System.out.println("Человек  бежит");
            }
            if (Subjects instanceof Robot) {
                System.out.println("Робот  бежит");
            } else {
                System.out.println("никто не бежит");
            }
        }
    }

    public static void jump(Subjects subjects) {
        if (Subjects instanceof Cat) {
            System.out.println("Кот прыгает");
        } else if (Subjects instanceof Human) {
            System.out.println("Человек  прыгает");
        } else if (Subjects instanceof Robot) {
            System.out.println("Робот  прыгает");
        } else {
            System.out.println("никто не прыгает");
        }
    }

}
