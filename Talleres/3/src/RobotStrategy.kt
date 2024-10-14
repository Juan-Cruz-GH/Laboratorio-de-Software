package CasseraBottaBianchi

interface RobotStrategy {
    fun run()
    fun onScannedRobot()
    fun onHitByBullet()
    fun onHitWall()
}
