package homeworkthree5;

public abstract class Stage {
    // этапы гонки
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}