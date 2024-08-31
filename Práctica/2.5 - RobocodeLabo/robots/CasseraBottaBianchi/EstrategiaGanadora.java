package CasseraBottaBianchi;

public class EstrategiaGanadora implements RobotStrategy {
    private LaboRobot laboRobot;
    public EstrategiaGanadora(LaboRobot laboRobot) {
        this.laboRobot = laboRobot;
    }
    @Override
    public void run() {
		laboRobot.back(60); // Mueve el robot hacia atrás en píxeles
		laboRobot.turnGunRight(360); // Gira el arma a la derecha en grados.
		laboRobot.back(100); // Mueve el robot hacia atrás en píxeles
		laboRobot.turnGunLeft(360); // Gira el arma a la derecha en grados.
    }
    @Override
    public void onScannedRobot() {
        laboRobot.fire(2);
    }
    @Override
    public void onHitByBullet() {
        laboRobot.back(10);
        laboRobot.turnGunRight(360);
    }
    @Override
    public void onHitWall() {
        laboRobot.ahead(20);
    }
}