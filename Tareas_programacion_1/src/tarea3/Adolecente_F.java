package tarea3;

public class Adolecente_F extends Ni�a {

	// Constructors
	public Adolecente_F() {
		super();
	}

	public Adolecente_F(String nombre) {
		super(nombre);
	}

	public Adolecente_F(String nombre, String apellido) {
		super(nombre, apellido);
	}

	public Adolecente_F(String nombre, String apellido, int edad) {
		super(nombre, apellido, edad);
	}
	// Methods

	void estudiar() {

		System.out.println("Estoy estudiando, actualmente estoy en " + nivel_secundaria);

	}

	void salirConAmigos() {
		System.out.println("hoy voy a salir con amigos");
	}

	public String getNivel_secundaria() {
		return nivel_secundaria;
	}

	public void setNivel_secundaria(String nivel_secundaria) {
		this.nivel_secundaria = nivel_secundaria;
	}

	public void cambiarNTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	// Field constants and variables
	private String nivel_secundaria;
	private String numeroTelefonico;

}
