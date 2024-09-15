package CasseraBottaBianchi;
import robocode.*;

public class CasseraBottaBianchiRobot extends JuniorRobot
{
	private Estratega estratega = EstrategaImplementacion.getInstance();
	// private RobotStrategy strategy = new EstrategiaGanadora(this);


	@Override
	public void run() {
		setColors(orange, blue, white, yellow, black);
		this.estratega.getEstrategia(this).run(this);
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	@Override
	public void onScannedRobot() {
		this.estratega.getEstrategia(this).onScannedRobot(this);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	@Override
	public void onHitByBullet() {
		this.estratega.getEstrategia(this).onHitByBullet(this);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	@Override
	public void onHitWall() {
		this.estratega.getEstrategia(this).onHitWall(this);
	}	

	public int getEnergy() {
		return energy;
	}

	public int getScannedAngle() {
		return scannedAngle;
	}

	public int getScannedEnergy() {
		return scannedEnergy;
	}

	public int getScannedDistance() {
		return scannedDistance;
	}

	public int getOthers() {
		return others;
	}
}