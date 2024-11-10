package CasseraBottaBianchi

class EstrategaImplementacion private constructor() : Estratega {
    private val estrategiaAtaque = Ataque()
    private val estrategiaDefensa = Defensa()

    companion object {
        private var instance: EstrategaImplementacion? = null

        fun getInstance(): EstrategaImplementacion {
            if (instance == null) {
                instance = EstrategaImplementacion()
            }
            return instance!!
        }
    }

    override fun getEstrategia(robot: LaboRobot): Estrategia {
        return if (robot.getEnergy() < 50 && robot.getOthers() < 3) {
            estrategiaDefensa
        } else if (robot.getEnergy() < 30) {
            estrategiaDefensa
        } else {
            estrategiaAtaque
        }
    }

    inner class Ataque : Estrategia {
        override fun run(robot: LaboRobot) {
            robot.ahead(200)
            robot.turnGunLeft(360)
            robot.back(10)
        }
        override fun onScannedRobot(robot: LaboRobot) {
            robot.fire(3.0)
        }

        override fun onHitByBullet(robot: LaboRobot) {
            robot.turnLeft(40)
        }

        override fun onHitWall(robot: LaboRobot) {
            robot.back(10)
            robot.turnRight(70)
            robot.ahead(400)
        }
    }

    inner class Defensa : Estrategia {
        override fun run(robot: LaboRobot) {
            robot.back(100)
            robot.turnGunRight(120)
            robot.back(140)
            robot.turnGunLeft(120)
        }
        override fun onScannedRobot(robot: LaboRobot) {
            robot.fire(1.0)
        }

        override fun onHitByBullet(robot: LaboRobot) {
            robot.back(20)
        }

        override fun onHitWall(robot: LaboRobot) {
            robot.ahead(20)
        }
    }
}