package CasseraBottaBianchi

import robocode.*

class LaboRobot : JuniorRobot() {

    private val estratega: Estratega = EstrategaImplementacion.getInstance()

    override fun run() {
        setColors(orange, blue, white, yellow, black)
        this.estratega.getEstrategia(this).run(this)
    }

    override fun onScannedRobot() {
        this.estratega.getEstrategia(this).onScannedRobot(this)
    }

    override fun onHitByBullet() {
        this.estratega.getEstrategia(this).onHitByBullet(this)
    }

    override fun onHitWall() {
        this.estratega.getEstrategia(this).onHitWall(this)
    }

    fun getEnergy(): Int {
        return energy
    }

    fun getScannedAngle(): Int {
        return scannedAngle
    }

    fun getScannedEnergy(): Int {
        return scannedEnergy
    }

    fun getScannedDistance(): Int {
        return scannedDistance
    }

    fun getOthers(): Int {
        return others
    }
}
