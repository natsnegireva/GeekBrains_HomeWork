package homework1.lesson1;

public abstract class CarAbstract {
    // следит за состоянием машины
    // сломалась - так как препятствие
    // починена
    private String model;
    private int integrity;

    public CarAbstract(String model){
        this.model = model;
        this.integrity = 100;
    }

    abstract int crash (int obstacle);
    abstract boolean isFully();

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
