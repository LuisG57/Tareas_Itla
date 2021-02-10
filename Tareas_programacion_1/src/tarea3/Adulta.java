package tarea3;

public class Adulta extends Mujer {
	// Constructors
	public Adulta() {
		super();
	}

	public Adulta(String nombre) {
		super(nombre);
	}

	public Adulta(String nombre, String apellido) {
		super(nombre, apellido);
	}

	public Adulta(String nombre, String apellido, int edad) {
		super(nombre, apellido, edad);
	}

	// Methods

	void graduado() {

		System.out.println("Estoy graduada de " + getCarrera_universitaria());

	}

	void retirado() {

		System.out.println(
				"Actualmente estoy retirada. pero cuando trabajaba lo hacia en el area de " + getArea_Trabajo());

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

	void nietos() {

		System.out.println("Tengo " + getNietos() + " nieto(s)");

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

	// Field constants and variables
	private String nieta, nieto;
	private int nietos = 0;
}
