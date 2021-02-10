package tarea3;

public class Adulto extends Hombre {

	// Constructors
	public Adulto() {
		super();
	}

	public Adulto(String nombre) {
		super(nombre);
	}

	public Adulto(String nombre, String apellido) {
		super(nombre, apellido);
	}

	public Adulto(String nombre, String apellido, int edad) {
		super(nombre, apellido, edad);
	}

	// Methods

	void graduado() {

		System.out.println("Estoy graduado de " + getCarrera_universitaria());

	}

	void retirado() {

		System.out.println(
				"Actualmente estoy retirado. pero cuando trabajaba lo hacia en el area de " + getArea_Trabajo());

	}

	void jugarConNietos() {

		System.out.println("Estoy jugando con mis nietos");

	}

	public int getNietos() {
		return nietos;
	}

	public void setNietos(int nietos) {
		this.nietos = nietos;
	}

	public void setNieto(Niño nieto) {
		this.nieto = nieto.getNombre();
	}

	public void setNieta(Niña nieta) {
		this.nieta = nieta.getNombre();
	}

	public String getNieta() {
		return nieta;
	}

	public void setNieta(String nieta) {
		this.nieta = nieta;
	}

	public String getNieto() {
		return nieto;
	}

	public void setNieto(String nieto) {
		this.nieto = nieto;
	}

	void nietos() {

		System.out.println("Tengo " + getNietos() + " nieto(s)");

	}

	// Field constants and variables

	private int nietos = 0;
	private String nieta, nieto;

}
