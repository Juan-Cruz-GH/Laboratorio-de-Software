package CasseraBottaBianchi;

public class EstrategaImplementacion implements Estratega {
    private static Ataque estrategiaAtaque = new Ataque();
    private static Defensa estrategiaDefensa = new Defensa();
    private static EstrategaImplementacion instance;

    private EstrategaImplementacion() {

    }

    public static EstrategaImplementacion getInstance() {
        // Patrón Singleton.
        if (instance == null) {
            instance = new EstrategaImplementacion();
        }
        return instance;
    }
    
    public Estrategia getEstrategia(CasseraBottaBianchiRobot robot) {
        if (robot.getEnergy() < 50 && robot.getOthers() < 3) {
            return estrategiaDefensa;
        }
        else if (robot.getEnergy() < 30) {
            return estrategiaDefensa;
        }
        else {
            return estrategiaAtaque;
        }
    }

    private static class Ataque implements Estrategia {
        public void run(CasseraBottaBianchiRobot robot) {
            robot.ahead(200); 
            robot.turnGunLeft(360);
            robot.back(10);
        }
        public void onScannedRobot(CasseraBottaBianchiRobot robot) {
            robot.fire(3);
        }
        public void onHitByBullet(CasseraBottaBianchiRobot robot) {
            robot.turnLeft(40);
        }
        public void onHitWall(CasseraBottaBianchiRobot robot) {
            robot.back(10);
            robot.turnRight(70);
            robot.ahead(400);
        }
    }
    private static class Defensa implements Estrategia {
        public void run(CasseraBottaBianchiRobot robot) {
            robot.back(100);
            robot.turnGunRight(120); 
            robot.back(140); 
            robot.turnGunLeft(120); 
        }
        public void onScannedRobot(CasseraBottaBianchiRobot robot) {
            robot.fire(1);
        }
        public void onHitByBullet(CasseraBottaBianchiRobot robot) {
            robot.back(20);
        }
        public void onHitWall(CasseraBottaBianchiRobot robot) {
            robot.ahead(20);
        }
    }
}
