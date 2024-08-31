package laboratorio;
import robocode.*;

public class LaboRobot extends JuniorRobot
{
	private RobotStrategy strategy = new UnaEstrategia();

	public void setStrategy(RobotStrategy strategy) {
		this.strategy = strategy;
	}
	@Override
	public void run() {
		this.strategy.run();
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	@Override
	public void onScannedRobot() {
		this.strategy.onScannedRobot();
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	@Override
	public void onHitByBullet() {
		this.strategy.onHitByBullet();
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	@Override
	public void onHitWall() {
		this.strategy.onHitWall();
	}	
}