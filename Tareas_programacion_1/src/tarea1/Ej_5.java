package tarea1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ej_5 {

	public static void main(String[] args) {

		// creamos objetos e inicializamos los mismos
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm:ss");
		LocalDateTime sysdateandtime = LocalDateTime.now();
		/*
		 * obtenemos los datos del systema
		 * y les damos formato
		 */
		System.out.println(format.format(sysdateandtime));

	}

}
