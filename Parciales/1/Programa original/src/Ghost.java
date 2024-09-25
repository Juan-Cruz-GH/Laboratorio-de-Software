
import java.util.Random;

public class Ghost extends Character {
	private static final long serialVersionUID = 1L;
	public boolean outsideCentralBox;

	public Ghost(double startingPointX, double startingPointY) {
		super(startingPointX, startingPointY);
		mustChangeDirection = false;
		outsideCentralBox = false;
	}

	public void move() {
		// get outside the box;
		if (!outsideCentralBox) {
			deltaX = 0;
			deltaY = -1;
			this.x = x + deltaX;
			this.y = y + deltaY;
			if (this.y == 140) {
				outsideCentralBox = true;
			}
			return;
		}
		randomChangeDirection(); //<----- Acá debería usarse el Strategy !!!
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

		if (mustChangeDirection) {
			mustChangeDirection = false;
			Random Rnd1 = new Random();
			Random Rnd2 = new Random();

			int i = Rnd1.nextInt(900);
			int j = Rnd2.nextInt(900);

			i = i * j;
			i = i % 4;
			switch (i) {
			case 0:
				deltaX = 0;
				deltaY = -1;
				break;
			case 1:
				deltaX = 0;
				deltaY = 1;
				break;
			case 2:
				deltaX = -1;
				deltaY = 0;
				break;
			case 3:
				deltaX = 1;
				deltaY = 0;
				break;

			}
		}

		

	}

	public void stopTimer() {
		super.stopTimer();
	}

}
