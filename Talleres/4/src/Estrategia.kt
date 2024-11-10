package CasseraBottaBianchi

interface Estrategia {
    fun run(robot: LaboRobot)
    fun onScannedRobot(robot: LaboRobot)
    fun onHitByBullet(robot: LaboRobot)
    fun onHitWall(robot: LaboRobot)
}
