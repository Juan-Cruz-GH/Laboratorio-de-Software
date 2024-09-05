package CasseraBottaBianchi;

public interface RobotStrategy {
    public void run();
    public void onScannedRobot();
    public void onHitByBullet();
    public void onHitWall();
}