package CasseraBottaBianchi

class EstrategiaGanadora(private val laboRobot: LaboRobot) : RobotStrategy {

    override fun run() {
        laboRobot.back(60) 
        laboRobot.turnGunRight(100) 
        laboRobot.back(100) 
        laboRobot.turnGunLeft(100) 
    }

    override fun onScannedRobot() {
        laboRobot.fire(2.0)
    }

    override fun onHitByBullet() {
        laboRobot.back(10)
    }

    override fun onHitWall() {
        laboRobot.ahead(20)
    }
}
