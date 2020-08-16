package homework1.model;

public class Robot {
    private int maxrun;
    private int maxjump;

    public Robot(int maxrun, int maxjump) {
        this.maxjump = maxjump;
        this.maxrun = maxrun;
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
