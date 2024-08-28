public class PoolConexiones {
	private static PoolConexiones instanciaSingleton;
	
	private PoolConexiones() {
		
	}
	
	public static PoolConexiones obtenerInstancia() {
		if (instanciaSingleton == null) {
			instanciaSingleton = new PoolConexiones();
		}
		return instanciaSingleton;
	}
}
