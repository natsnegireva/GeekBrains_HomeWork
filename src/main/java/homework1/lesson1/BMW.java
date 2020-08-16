package homework1.lesson1;

public class BMW extends Car {
    private String model;
    private int integrity;

    public BMW(String model) {
        super(model);
    }

    @Override
    public int crash (int obstacle) { // переопределили метод вернет состояние, когда получит препятствие
        return integrity - obstacle;
    }

    public int getIntegrity() {
        return integrity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setIntegrity(int integrity) {
        this.integrity = integrity;
    }

}
