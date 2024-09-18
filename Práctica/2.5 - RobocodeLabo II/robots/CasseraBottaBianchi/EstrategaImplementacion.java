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
            robot.back(60); // Mueve el robot hacia atrás en píxeles
            robot.turnGunRight(200); // Gira el arma a la derecha en grados.
            robot.back(100); // Mueve el robot hacia atrás en píxeles
            robot.turnGunLeft(200); // Gira el arma a la derecha en grados.
        }
        public void onScannedRobot(CasseraBottaBianchiRobot robot) {
            robot.fire(2);
        }
        public void onHitByBullet(CasseraBottaBianchiRobot robot) {
            robot.back(10);
            //robot.turnGunRight(360);
        }
        public void onHitWall(CasseraBottaBianchiRobot robot) {
            robot.ahead(40);
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
