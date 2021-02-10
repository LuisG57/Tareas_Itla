package tarea2;

public class Ej_2 {

	public static void main(String[] args) {

		Cuenta c1 = new Cuenta("Freidy");
		Cuenta c2 = new Cuenta("Daniel");
		Cuenta c3 = new Cuenta();

		c2.ingresar(1000);
		c2.transferir(c1, 500);
		c3.Balance();

	}

}

class Cuenta {

	public Cuenta() {
		Balance = 0;
		this.nombre = "Cliente" + cNumber;
	}

	public Cuenta(String nombre) {

		Balance = 0;

		this.nombre = nombre;

	}

	// Setters
	void ingresar(int monto) {

		Balance += monto;

		System.out
				.println("Sr: " + this.nombre + ", usted ha recibido un ingreso de RD$" + monto + " pesos Domnicanos");
	}

	void reintegro(int monto) {
		Balance -= monto;

		System.out
				.println("Sr: " + this.nombre + ", usted ha reintegrado un monto de RD$" + monto + " pesos Domnicanos");
	}

	void transferir(Cuenta cuenta, int monto) {
		cuenta.ingresar(monto);
		this.Balance -= monto;
		System.out.println("se ha realizado su transferencia a la cuenta perteneciente a " + cuenta.propietario()
				+ " con un monto de " + monto + " pesos Domnicanos");
	}

	// Getters
	int Balance() {
		System.out.println("SR " + this.nombre + " su balance actual es " + this.Balance);
		return Balance;
	}

	String propietario() {

		return this.nombre;
	}

	private int Balance;
	private String nombre;
	private static int cNumber = 0;

}