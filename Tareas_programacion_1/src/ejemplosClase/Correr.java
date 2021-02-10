package ejemplosClase;

public class Correr {

	public static void main(String[] args) {

		TV samsung = new TV("Samsung", "Qled");
		TV lg = new TV("LG", "UHD");

	}

}

class TV {

	// Class Constructor
	public TV(String Marca, String modelo) {
		marca = Marca;
		this.modelo = modelo;
		System.out.println("La TV es una " + marca + " de modelo " + this.modelo);
	}

	// Class methods
	void encender() {
	}

	void apagar() {
	}

	int subir_vol() {

		return 1;
	}

	int bajar_vol() {

		return -1;
	}

	// Class fields
	private String modelo, marca;

}
