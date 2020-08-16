package homework1.lesson1;

public class Car extends CarAbstract implements CarInterface {
    private String model;
    private int integrity; // целостность

    public Car(String model) {
        super(model);
    }

    @Override
    public void run() { // едет
        System.out.println("Машина едет");
    }
    @Override
    public void goneToService() { // в сервисе
        System.out.println("Машина в сервисе");
    }

    @Override
    public int crash(int obstacle) { // сломалась
        return obstacle;
    }

    @Override
    boolean isFully() { // починена
        return false;
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
