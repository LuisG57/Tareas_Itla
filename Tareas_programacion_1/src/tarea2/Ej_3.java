package tarea2;

public class Ej_3 {

	public static void main(String[] args) {

		Contador cont = new Contador();
		//this is just to test
		while (cont.resultado()<10) {
			cont.incre();
			System.out.println("ahora mismo nos encotramos en la vuelta de bucle numero " + cont.resultado());
		}
		
	}

}

class Contador {

	public Contador() {

		contador = 0;

	}

	// setters
	void decrementar(int cuanto) {
		contador -= cuanto;
		System.out.println("se ha decrementado el contador, en este momento el contador es igual a " + contador
				+ " en total se decremento en " + cuanto);
	}

	void incrementar(int cuanto) {
		contador += cuanto;
		System.out.println("se ha incrementado el contador, en este momento el contador es igual a " + contador
				+ " en total se incrementado en " + cuanto);
	}

	void decre() {
		contador--;
	}

	void incre() {
		contador++;
	}

	// getters
	int resultado() {
		//System.out.println("El contador en este momento es igual a " + contador);
		return contador;
	}

	private int contador;

}