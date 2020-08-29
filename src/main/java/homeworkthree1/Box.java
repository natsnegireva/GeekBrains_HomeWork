package homeworkthree1;


import java.util.ArrayList;

public class Box<F extends Fruit> {
    private ArrayList<F> box;
    private F fruit;
    private int quantity;

    public Box(ArrayList<F> box) {
        this.box = box;
    }

    // добавить один фрукт
    public ArrayList<F> addFruit(ArrayList<F> box, F fruit) {
        box.add( fruit );
        return box;
    }

    //добавить несколько фруктов
    public ArrayList<F> putFruits(ArrayList<F> box, F fruit, int quantity) {
        for (int i = 0; i <= quantity; i++) {
            box.add( fruit );
        }
        return box;
    }

    // расчитать вес коробки
    public float getWeight() {
        float weight = fruit.getWeight() * quantity;
        return weight;
    }

    // перекладываем все в другую коробку
    public void pourTo(ArrayList<F> box, ArrayList<F> otherBox) {
        if (box != null && otherBox.isEmpty()) {
            otherBox.addAll( box );
            box.isEmpty();
        } else if (box.equals( otherBox ) && box != null && otherBox != null) {
            otherBox.addAll( box );
            box.isEmpty();
        }
    }

    // сравниваем вес коробок
    public boolean compareBox(ArrayList<F> box) {
        if (getWeight() == this.getWeight()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;
        Box<F> box = (Box<F>) o;
        return fruit.equals( box.fruit );
    }

    @Override
    public int hashCode() {
        return fruit.hashCode();
    }

    public ArrayList<F> getBox() {
        return box;
    }

    public void setBox(ArrayList<F> box) {
        this.box = box;
    }
}
