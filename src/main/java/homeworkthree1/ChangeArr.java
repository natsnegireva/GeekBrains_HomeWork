package homeworkthree1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChangeArr<T> {
    private List<T> list;

    public ChangeArr(List<T> list) {
        this.list = list;
    }

    // 1. Написать метод, который меняет два элемента массива местами
    // (массив может быть любого ссылочного типа)
    public List<T> swapArr(List<T> list, int i, int j) throws IndexOutOfBoundsException {
        list.set(i, list.set(j, list.get(i)));
        return list;
    }

    // 2. Написать метод, который преобразует массив в ArrayList;
    public ArrayList<T> arrToArrList(T[] array) {
        return new ArrayList<T>( Arrays.asList( array ) );
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
