package CasseraBottaBianchi

import robocode.*

class LaboRobot : JuniorRobot() {

    private var strategy: RobotStrategy = EstrategiaGanadora(this)

    fun setStrategy(strategy: RobotStrategy) {
        this.strategy = strategy
    }

    override fun run() {
        setColors(orange, blue, white, yellow, black)
        strategy.run()
    }

    override fun onScannedRobot() {
        strategy.onScannedRobot()
    }

    override fun onHitByBullet() {
        strategy.onHitByBullet()
    }

    override fun onHitWall() {
        strategy.onHitWall()
    }
}
