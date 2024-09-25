import java.util.Random;

public class Estrategias {
	private static Estrategias instancia;
	private Strategy estrategiaActual;
	private EstrategiaDireccionOpuesta estrategiaDireccionOpuesta = new EstrategiaDireccionOpuesta();
	private EstrategiaDireccionAleatoria estrategiaDireccionAleatoria = new EstrategiaDireccionAleatoria();
	private EstrategiaDireccionZombie estrategiaDireccionZombie = new EstrategiaDireccionZombie();

	private Estrategias() {
		// Constructor privado para impedir que se creen instancias por fuera del
		// Singleton.
	}

	public static Estrategias Singleton() {
		if (instancia == null) {
			instancia = new Estrategias();
		}
		return instancia;
	}

	public void setEstrategiaDireccionOpuesta() {
		estrategiaActual = estrategiaDireccionOpuesta;
	}

	public void setEstrategiaDireccionAleatoria() {
		estrategiaActual = estrategiaDireccionAleatoria;
	}

	public void setEstrategiaDireccionZombie() {
		estrategiaActual = estrategiaDireccionZombie;
	}

	public void cambiarOrientacion(Ghost ghost, boolean mustChangeDirection) {
		estrategiaActual.changeDirection(ghost, mustChangeDirection);
	}

	private class EstrategiaDireccionAleatoria implements Strategy {

		@Override
		public void changeDirection(Ghost ghost, boolean mustChangeDirection) {
			if (mustChangeDirection) {
				ghost.mustChangeDirection = false;
				Random Rnd1 = new Random();
				Random Rnd2 = new Random();

				int i = Rnd1.nextInt(900);
				int j = Rnd2.nextInt(900);

				i = i * j;
				i = i % 4;
				switch (i) {
				case 0:
					ghost.direccion = Direcciones.MOVER_HACIA_ARRIBA;
					break;
				case 1:
					ghost.direccion = Direcciones.MOVER_HACIA_ABAJO;
					break;
				case 2:
					ghost.direccion = Direcciones.MOVER_HACIA_IZQUIERDA;
					break;
				case 3:
					ghost.direccion = Direcciones.MOVER_HACIA_DERECHA;
					break;
				}
			}

		}

	}

	private class EstrategiaDireccionOpuesta implements Strategy {

		@Override
		public void changeDirection(Ghost ghost, boolean mustChangeDirection) {
			if (mustChangeDirection) {
				ghost.mustChangeDirection = false;
				switch (ghost.direccion) {
				case MOVER_HACIA_ABAJO:
					ghost.direccion = Direcciones.MOVER_HACIA_ARRIBA;
					break;
				case MOVER_HACIA_ARRIBA:
					ghost.direccion = Direcciones.MOVER_HACIA_ABAJO;
					break;
				case MOVER_HACIA_DERECHA:
					ghost.direccion = Direcciones.MOVER_HACIA_IZQUIERDA;
					break;
				case MOVER_HACIA_IZQUIERDA:
					ghost.direccion = Direcciones.MOVER_HACIA_DERECHA;
					break;
				}
			}
		}

	}

	private class EstrategiaDireccionZombie implements Strategy {

		@Override
		public void changeDirection(Ghost ghost, boolean mustChangeDirection) {
			Random Rnd1 = new Random();
			Random Rnd2 = new Random();

			int i = Rnd1.nextInt(900);
			int j = Rnd2.nextInt(900);

			i = i * j;
			i = i % 4;
			switch (i) {
			case 0:
				ghost.direccion = Direcciones.MOVER_HACIA_ARRIBA;
				break;
			case 1:
				ghost.direccion = Direcciones.MOVER_HACIA_ABAJO;
				break;
			case 2:
				ghost.direccion = Direcciones.MOVER_HACIA_IZQUIERDA;
				break;
			case 3:
				ghost.direccion = Direcciones.MOVER_HACIA_DERECHA;
				break;
			}
		}
	}
}
