package tarea2;

public class Ej_1 {

	public static void main(String[] args) {

		Persona p1 = new Persona("Adriana", "Lora", 30, "Si");
		Persona p2 = new Persona("Dereck", "Martinez", 40, "Si");
		Persona p3 = new Persona("Jesus", "Olivares", 23, "No");
		Persona p4 = new Persona("Darianna", "Brito", 20, "No");
		Persona p5 = new Persona("Anderson", "Carmona", 27, "Si");
		Persona p6 = new Persona("Estarlin", "Cuesta", 29, "NO");
		Persona p7 = new Persona("Virginia", "Vargas", 53, "Si");

		p1.programar();
		p1.probarPrograma();
		p1.publicarPrograma();
		p2.recortar();
		p2.sacarCejas();
		p2.hacerCerquillo();
		p3.programar();
		p3.probarPrograma();
		p3.publicarPrograma();
		p4.ponerTinte();
		p4.pasarBlower();
		p4.peinar();
		p5.recortar();
		p5.sacarCejas();
		p5.hacerCerquillo();
		p6.programar();
		p6.probarPrograma();
		p6.publicarPrograma();
		p7.ponerTinte();
		p7.pasarBlower();
		p7.peinar();

	}

}

class Persona {
	// constructors
	public Persona(String nombre, String apellido, int edad, String casado) {

		this.nombre = nombre;
		this.setApellido(apellido);
		this.edad = edad;

		if (casado.equalsIgnoreCase("si")) {
			this.casado = true;
		} else {
			this.casado = false;
		}

	}

	// field methods

	void definir_DNI(String DNI) {
		this.DNI = DNI;
		System.out.println("El DNI se ha definido correctamente y se ha definido como: " + DNI);
	}

	void redefinir_EstadoC(String casado) {

		if (casado.equalsIgnoreCase("si")) {
			this.casado = true;
		} else {
			this.casado = false;
		}
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	// ---Metodos de profesion
	// ------------------------------------------------------//

	// profesion programador
	void programar() {
		System.out.println("Yo " + nombre + " estoy programando");
	}

	void probarPrograma() {
		System.out.println("Yo " + nombre + " estoy probando un programa");
	}

	void publicarPrograma() {
		System.out.println("Yo " + nombre + " estoy publicando un programa");
	}

	// profesion barbero
	void recortar() {
		System.out.println("Yo " + nombre + " estoy recortando");
	}

	void sacarCejas() {
		System.out.println("Yo " + nombre + " estoy sacando cejas");
	}

	void hacerCerquillo() {
		System.out.println("Yo " + nombre + " estoy haciendo un cerquillo");
	}

	// profesion estilista
	void ponerTinte() {
		System.out.println("Yo " + nombre + " estoy poninendo un tinte");
	}

	void pasarBlower() {
		System.out.println("Yo " + nombre + " estoy pasando el blower");
	}

	void peinar() {
		System.out.println("Yo " + nombre + " estoy peinando a un cliente");
	}

	// class fields
	private String nombre, apellido, DNI;
	private int edad;
	private boolean casado;

}
