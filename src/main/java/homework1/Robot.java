package homework1;

public class Robot extends SubAbstract implements Movement {
    private int maxrun;
    private int maxjump;

    public Robot(int maxrun, int maxjump) {
        this.maxjump = maxjump;
        this.maxrun = maxrun;
    }

    public Robot() {
    }

    @Override
    public boolean stopRun (int length) {
        if (maxrun > length) {
            return false;
        }
        return true;
    }

    @Override
    public boolean stopJump(int height) {
        if (maxjump > height) {
            return false;
        }
        return true;
    }

    @Override
    public void run() {
        System.out.println("Робот бежит");
    }
    @Override
    public void jump() {
        System.out.println("Робот прыгает");
    }
    public int getMaxrun() {
        return maxrun;
    }

    public void setMaxrun(int maxrun) {
        this.maxrun = maxrun;
    }

    public int getMaxjump() {
        return maxjump;
    }

    public void setMaxjump(int maxjump) {
        this.maxjump = maxjump;
    }
}
