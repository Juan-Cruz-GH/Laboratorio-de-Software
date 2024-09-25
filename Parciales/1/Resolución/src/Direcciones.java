
public enum Direcciones {
	INICIAL(0, 0), MOVER_HACIA_ARRIBA(0, -1), MOVER_HACIA_ABAJO(0, 1), MOVER_HACIA_IZQUIERDA(-1, 0),
	MOVER_HACIA_DERECHA(1, 0);

	private int x;
	private int y;

	Direcciones(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
