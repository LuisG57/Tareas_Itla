package tarea1;

import java.util.Scanner;

public class Ej_15 {

	public static void main(String[] args) {

		System.out.println("Inserta un numero entre 0 y 10 para darte su tabla de multiplicar");
		Scanner entrada = new Scanner(System.in);
		int n_introducido = entrada.nextInt();
		int resultado;
		System.out.println("La tabla de multiplicar del " + n_introducido + " Es la siguiente");
		for (int i = 1; i < 11; i++) {
			resultado = n_introducido * i;
			System.out.println(n_introducido + " X " + i + " = " +resultado);
		}
		entrada.close();

	}

}
