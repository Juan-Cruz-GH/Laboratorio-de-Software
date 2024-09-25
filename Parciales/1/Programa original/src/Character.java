import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Character extends JPanel {

	protected static final long serialVersionUID = 1L;
	protected double x;
	protected int rounds;
	protected double y;
	protected int deltaX;
	protected int deltaY;
	double Xi, Yi;
	protected ImageIcon image;
	Board board;

	public boolean mustChangeDirection;
	protected Timer timer;
	
	public Character(double startingPointX, double startingPointY) {
		deltaX = 0;
		deltaY = 0;
		this.x = startingPointX;
		this.y = startingPointY;
		this.image = leftIcone();
	}

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
		if (this.board==null)
			return;

	
		double squareHeight = Board.MAP_HEIGHT / 31;
		double squareWidth = Board.MAP_WIDTH / 28;
		Xi = (this.x + deltaX - squareWidth / 2) / squareWidth;
		Yi = (this.y + deltaY - squareHeight / 2) / squareHeight;

		this.onOutOfRange();

		if (loop(Xi, Yi))
			return;

		if (board.isClear((int) Yi + 1, (int) Xi + 1)) {
			this.x = x + deltaX;
			this.y = y + deltaY;
			this.onNonStucked();
		
		} else this.onStucked();

	}

	protected void onNonStucked() {
		if (this instanceof Pacman)
			board.eat((int) Yi + 1, (int) Xi + 1);
	}
	protected void onStucked() {
		if (this instanceof Ghost) {
			mustChangeDirection = true;
		}
	}
	
	private void onOutOfRange() {
		if (this.x + deltaX < 0 && Yi + 1 != 14 && this instanceof Ghost) {
			deltaX = 1;
		}
		if (this.y + deltaY < 11 && this instanceof Ghost) {
			Random rnd = new Random();
			int i = rnd.nextInt(87);
			i = i % 3;
			switch (i) {
			case 0:
				deltaX = 0;
				deltaY = 1;
				break;
			case 1:
				deltaX = 1;
				deltaY = 0;
				break;
			case 2:
				deltaX = -1;
				deltaY = 0;
				break;
			}
		}
		

	}

	private boolean loop(double Xi, double Yi) {
		boolean ans = false;
		if ((int) Yi + 1 == 14 && ((int) Xi + 2 == 0 || Xi + 1 == 28)) {
			if (Xi + 1 == 28)
				this.x = -9;
			else
				this.x = 411.5;
			ans = true;
		}
		return ans;
	}


	public void startingPoint(double d, double e) {
		this.x = d;
		this.y = e;
		this.deltaX = 0;
		this.deltaY = 0;
	}

	public void stopTimer() {
		timer.stop();
	}

	public void startTimer() {
		timer.restart();
	}

}
