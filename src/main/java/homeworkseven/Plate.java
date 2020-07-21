package homeworkseven;

import java.util.Scanner;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    // Считаем, что если коту мало еды в тарелке, то он ее просто не трогает,
// то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
    public void infoFood(int appetite, String name) {
        if (appetite > food) {
            food = 0;
            //System.out.println(name + " остался голодный");
        } else if (food == 0) {
            putFood();
        } else {
            food = food - appetite;
            System.out.println("В тарелке осталось " + food + " еды");
            System.out.println(name + " сытый");
        }
    }

    // Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    public void putFood() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Еда закончилась. Введите сколько хотите добавить еды в тарелку");
        int input_number = sc.nextInt();
        if (input_number >= 0) {
            food += input_number;
            setFood(food);
            System.out.println("В тарелке " + food + " еды");
        } else {
            System.out.println(input_number + " - Это не еда");
        }
        sc.close();
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
