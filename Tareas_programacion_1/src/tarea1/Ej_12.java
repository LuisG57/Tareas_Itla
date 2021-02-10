package tarea1;

import java.util.Scanner;

public class Ej_12 {

	public static void main(String[] args) {

		int number = 1;
		Scanner entrada = new Scanner(System.in);
		do {
			System.out.println("Introduzca un numero");
			number = entrada.nextInt();
			System.out.println(Math.pow(number, 2));
		} while (number >= 0);
		entrada.close();
		System.out.println("Listo");
	}

}
