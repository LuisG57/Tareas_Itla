package tarea1;

public class Ej_4 {

	public static void main(String[] args) {

		float flotante = 10152466.25f;
		byte Byte = (byte) (5 + flotante);

		// Perdemos datos al castear porque byte es muy pequeño para ese numero
		// tambien perdemos informacion porque los decimales se pierden

		System.out.println(Byte);

	}

}
