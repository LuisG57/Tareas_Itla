package tarea1;

public class Ej_16 {

	public static void main(String[] args) {
		// variables
		int suma = 0, num_1 = 0, num_2 = 1, acumulador, meta_100 = 100;
		// primera impresion
		System.out.println(num_1);
		System.out.println(num_2);
		suma = suma + num_2;
		// bucle hasta el 100 para la seria fibonacci
		do {
			acumulador = num_1;
			num_1 = num_2;
			num_2 = acumulador + num_1;
			suma = suma + num_2;
			System.out.println(num_2);
		} while (num_1 + num_2 < meta_100);
		// impresion final
		System.out.println("\n\n\nLa suma de la serie Fibonacci hasta el 100 es = " + suma);

	}

}
