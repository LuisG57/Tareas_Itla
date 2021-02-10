package tarea1;

import java.util.Scanner;

public class Ej_10 {

	public static void main(String[] args) {

		System.out.println("Introduce tu primer numero");
		Scanner entrada = new Scanner(System.in);
		int n1 = entrada.nextInt();
		System.out.println("Pon tu segundo numero");
		int n2 = entrada.nextInt();
		entrada.close();
		if (n1 == n2) {
			System.out.println("Numeros iguales");
		} else {
			System.out.println("Numeros no iguales");
		}
	}

}
