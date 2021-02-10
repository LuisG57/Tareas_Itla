package tarea1;

import java.util.Scanner;

public class Ej_11 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingresa la nota de 0 a 10");
		int grade = entrada.nextInt();
		entrada.close();
		switch (grade) {
		case 1:
			System.out.println("Insuficiente");
			break;
		case 2:
			System.out.println("Insuficiente");
			break;
		case 3:
			System.out.println("Insuficiente");
			break;
		case 4:
			System.out.println("Insuficiente");
			break;
		case 5:
			System.out.println("Insuficiente");
			break;
		case 6:
			System.out.println("Insuficiente");
			break;
		case 7:
			System.out.println("Suficiente");
			break;
		case 8:
			System.out.println("Bien");
			break;
		case 9:
			System.out.println("Bien");
			break;
		case 10:
			System.out.println("Bien");
			break;
		}

	}

}
