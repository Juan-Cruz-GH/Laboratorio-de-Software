package CasseraBottaBianchi;

public interface Estrategia {
    public void run(CasseraBottaBianchiRobot robot);
    public void onScannedRobot(CasseraBottaBianchiRobot robot);
    public void onHitByBullet(CasseraBottaBianchiRobot robot);
    public void onHitWall(CasseraBottaBianchiRobot robot);
}
