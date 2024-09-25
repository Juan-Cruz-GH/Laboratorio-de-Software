
public enum ContenidoCelda {
	WALL(1), FOOD(2), EMPTY(3);

	private int valor;

	ContenidoCelda(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

}
