package tarea1;

public class Ej_17 {

	public static void main(String[] args) {

		int p[] = serie_fibo_parapromeido(1000);
		System.out.println("El promedio de la serie fibonacci hasta el 1000 es " + p[1] / p[0]);

	}

	static int[] serie_fibo_parapromeido(int hasta) {
		int contador = 1;
		int suma = 0, num_1 = 0, num_2 = 1, acumulador, meta_100 = hasta;
		suma = suma + num_2;

		do {
			contador++;
			acumulador = num_1;
			num_1 = num_2;
			num_2 = acumulador + num_1;
			suma = suma + num_2;
		} while (num_1 + num_2 < meta_100);

		int[] devuelta = new int[] { contador, suma };

		return devuelta;
	}

}
