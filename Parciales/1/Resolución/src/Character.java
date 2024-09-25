import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class Character extends JPanel {

	protected static final long serialVersionUID = 1L;
	protected double x;
	protected int rounds;
	protected double y;
	protected Direcciones direccion;
	double Xi, Yi;
	protected ImageIcon image;
	Board board;

	public boolean mustChangeDirection;
	protected Timer timer;

	public Character(double startingPointX, double startingPointY) {
		direccion = Direcciones.INICIAL;
		this.x = startingPointX;
		this.y = startingPointY;
		this.image = leftIcone();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		image.paintIcon(this, g, (int) x, (int) y);
	}

	protected ImageIcon leftIcone() {
		return null;
	}

	public void setBoard(Board b) {
		board = b;

	}

	public void move() {

		// if you didnt set the board yat return
		if (this.board == null) {
			return;
		}

		double squareHeight = Board.MAP_HEIGHT / 31;
		double squareWidth = Board.MAP_WIDTH / 28;
		Xi = (this.x + direccion.getX() - squareWidth / 2) / squareWidth;
		Yi = (this.y + direccion.getY() - squareHeight / 2) / squareHeight;

		this.onOutOfRange();

		if (loop(Xi, Yi)) {
			return;
		}

		if (board.isClear((int) Yi + 1, (int) Xi + 1)) {
			this.x = x + direccion.getX();
			this.y = y + direccion.getY();
			this.onNonStucked();

		} else {
			this.onStucked();
		}

	}

	protected abstract void onNonStucked(); // {

	protected abstract void onStucked();

	protected abstract void onOutOfRange();

	private boolean loop(double Xi, double Yi) {
		boolean ans = false;
		if ((int) Yi + 1 == 14 && ((int) Xi + 2 == 0 || Xi + 1 == 28)) {
			if (Xi + 1 == 28) {
				this.x = -9;
			} else {
				this.x = 411.5;
			}
			ans = true;
		}
		return ans;
	}

	public void startingPoint(double d, double e) {
		this.x = d;
		this.y = e;
		this.direccion = Direcciones.INICIAL;
	}

	public void stopTimer() {
		timer.stop();
	}

	public void startTimer() {
		timer.restart();
	}

}
