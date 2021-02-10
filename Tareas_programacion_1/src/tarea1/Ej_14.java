package tarea1;

import java.util.Scanner;

public class Ej_14 {

	public static void main(String[] args) {

		int n_introducido, resultado = 0;
		Scanner entrada = new Scanner(System.in);
		for (int i = 0; i < 15; i++) {

			System.out.println("Introduce un numero");
			n_introducido = entrada.nextInt();
			resultado += n_introducido;

		}
		System.out.println("Has introducido 15 numeros y la suma de ellos es = " + resultado);
		entrada.close();

	}

}
