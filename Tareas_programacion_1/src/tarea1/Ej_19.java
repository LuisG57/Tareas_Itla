package tarea1;

import java.util.Scanner;

public class Ej_19 {

	public static void main(String[] args) {

		int numero;
		Scanner entrada = new Scanner(System.in);
		numero = entrada.nextInt();
		System.out.println("Factorial del numero " + numero + " que diste es = " + calcular_factorial(numero));
		entrada.close();
	}

	public static int calcular_factorial(int numero) {
		int resultado = 1;
		for (int i = 1; i <= numero; i++) {
			resultado = resultado * i;
		}
		return resultado;

	}

}
