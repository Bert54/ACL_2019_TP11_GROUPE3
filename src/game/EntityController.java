package game;

public interface EntityController {
    public void onUpdate();
    public void setStopLeft(boolean stopLeft);
    public void setStopRight(boolean stopRight);
    public void setStopTop(boolean stopTop);
    public void setStopBottom(boolean stopBottom);
}
