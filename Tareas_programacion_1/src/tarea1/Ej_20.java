package tarea1;

import java.util.Scanner;

public class Ej_20 {

	public static void main(String[] args) {

		System.out.println("Ingresa un numero y te doy los factoriales enter 1 y ese numero");
		Scanner entrada = new Scanner(System.in);
		int numero, resultado = 1;
		do {
			numero = entrada.nextInt();
			if (numero < 1)
				System.out.println("ingresa un numero mayor a 1 por favor");
		} while (numero < 1);
		for (int i = numero; i != 0; i--) {
			for (int j = i; j != 1; j--) {
				resultado = resultado * j;
			}
			System.out.println("Factorial de " + i + " = " + resultado);
			resultado = 1;
		}
		entrada.close();
	}

}
