public class TestVacuna {

	public static void main(String[] args) {
		Vacuna vacunas[] = new Vacuna[5];
		vacunas[0] = new Vacuna("unaMarca", "Argentina", "Covid", 2);
		vacunas[1] = new Vacuna("otraMarca", "USA", "Influenza", 3);
		vacunas[2] = new Vacuna("Marcaa", "Rusia", "Covid", 1);
		vacunas[3] = new Vacuna("123", "Inglaterra", "Covid", 1);
		vacunas[4] = new Vacuna("XYZ", "Brasil", "Hepatitis", 2);
		Vacuna v5 = new Vacuna("XYZ", "Brasil", "Hepatitis", 2);
		
		for (Vacuna vacuna : vacunas) {
			System.out.println(vacuna);
		}
		
		System.out.println(vacunas[4] == v5);
		System.out.println(vacunas[4].equals(v5));
	}
}
