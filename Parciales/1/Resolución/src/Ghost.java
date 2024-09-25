
import java.util.Random;

public class Ghost extends Character {
	private static final long serialVersionUID = 1L;
	public boolean outsideCentralBox;
	private Estrategias estrategia = Estrategias.Singleton();

	public Ghost(double startingPointX, double startingPointY) {
		super(startingPointX, startingPointY);
		mustChangeDirection = false;
		outsideCentralBox = false;
		estrategia.setEstrategiaDireccionZombie(); // Estrategia enchufable.
	}

	@Override
	public void move() {
		// get outside the box;
		if (!outsideCentralBox) {
			direccion = Direcciones.MOVER_HACIA_ARRIBA;
			this.x = x + direccion.getX();
			this.y = y + direccion.getY();
			if (this.y == 140) {
				outsideCentralBox = true;
			}
			return;
		}
		estrategia.cambiarOrientacion(this, mustChangeDirection); // Haciendo uso del Strategy.
		super.move();
		if (eatPacMan()) {
			this.board.restart();
			outsideCentralBox = false;
		}

		repaint();

	}

	private boolean eatPacMan() {
		return this.board != null
				? Math.sqrt(Math.pow(this.x - this.board.pacman.x, 2) + Math.pow(this.y - this.board.pacman.y, 2)) < 15
				: false;
	}

	private void randomChangeDirection() {

	}

	@Override
	public void stopTimer() {
		super.stopTimer();
	}

	@Override
	protected void onNonStucked() {

	}

	@Override
	protected void onStucked() {
		mustChangeDirection = true;
	}

	@Override
	protected void onOutOfRange() {
		if (this.x + direccion.getX() < 0 && Yi + 1 != 14) {
			direccion.setX(1);
		}
		if (this.y + direccion.getY() < 11) {
			Random rnd = new Random();
			int i = rnd.nextInt(87);
			i = i % 3;
			switch (i) {
			case 0:
				direccion = Direcciones.MOVER_HACIA_ABAJO;
				break;
			case 1:
				direccion = Direcciones.MOVER_HACIA_DERECHA;
				break;
			case 2:
				direccion = Direcciones.MOVER_HACIA_IZQUIERDA;
				break;
			}
		}

	}

}
