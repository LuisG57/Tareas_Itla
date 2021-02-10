package tarea1;

public class Ej_18 {

	public static void main(String[] args) {

		int p[] = serie_fibo_paraelementosenmil(2000);
		System.out.println("Los elementos entre la serie fibonacci entre 1000 y 2000 son = " + p[0]);

	}

	static int[] serie_fibo_paraelementosenmil(int hasta) {
		int contador = 0;
		int suma = 0, num_1 = 0, num_2 = 1, acumulador, meta_100 = hasta;
		suma = suma + num_2;

		do {
			acumulador = num_1;
			num_1 = num_2;
			num_2 = acumulador + num_1;
			suma = suma + num_2;
			if (num_2 > 1000)
				contador++;
		} while (num_1 + num_2 < meta_100);

		int[] devuelta = new int[] { contador, suma };

		return devuelta;
	}

}
