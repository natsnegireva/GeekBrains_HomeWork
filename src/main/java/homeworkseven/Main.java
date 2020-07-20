package homeworkseven;

public class Main {


    public static void main(String[] args) {
        int foodCount = 80;
        // Создать массив котов и тарелку с едой, попросить всех котов покушать из этой
        // тарелки и потом вывести информацию о сытости котов в консоль
        Cat cat = new Cat("Mursik", 10);
        Cat cat1 = new Cat("Barsik", 70);
        Cat cat2 = new Cat("Svetik", 10);
        Cat cat3 = new Cat("ProstoKotik", 15);
        Plate plate = new Plate(foodCount);

        System.out.println("На тарелке " + foodCount + " порций еды");
        cat.hungry();
        cat.eat(plate);
        cat.setAppetite(Math.max(cat.getAppetite() - foodCount, 0));

        cat1.hungry();
        cat1.eat(plate);
        cat1.setAppetite(Math.max(cat1.getAppetite() - foodCount, 0));

        cat2.hungry();
        cat2.eat(plate);
        cat2.setAppetite(Math.max(cat2.getAppetite() - foodCount, 0));

        cat3.hungry();
        cat3.eat(plate);
        cat3.setAppetite(Math.max(cat3.getAppetite() - foodCount, 0));

        plate.putFood();

    }

}
