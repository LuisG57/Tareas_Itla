package tarea1;

import java.util.Scanner;

public class Ej_13 {

	public static void main(String[] args) {

		int n_introducido, acumulador = 0;
		Scanner entrada = new Scanner(System.in);
		do {
			System.out.println("Introduzca un numero");
			n_introducido = entrada.nextInt();
			acumulador += n_introducido;
		} while (n_introducido != 0);
		entrada.close();
		System.out.println("Has introducido un 0 la suma de todos los numeros es = " + acumulador);

	}

}
