package homework1;

public class Human extends SubAbstract implements Movement {
    private int maxrun;
    private int maxjump;

    public Human(int maxrun, int maxjump) {
        this.maxjump = maxjump;
        this.maxrun = maxrun;
    }

    public Human() {
    }

    @Override
    public boolean stopRun(int length) {
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
        System.out.println("Человек бежит");
    }

    @Override
    public void jump() {
        System.out.println("Человек прыгает");
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
